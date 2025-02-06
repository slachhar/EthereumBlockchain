import dotenv from "dotenv";
import Web3 from "web3";
import fs from "fs";

// Load environment variables explicitly
dotenv.config();

if (!process.env.GANACHE_URL) {
    console.error("❌ GANACHE_URL is not set. Check your .env file.");
    process.exit(1);
}

// Connect to Ganache (ensure the variable is correctly read)
console.log(`🔗 Connecting to Ganache at: ${process.env.GANACHE_URL}`);
const web3 = new Web3(new Web3.providers.HttpProvider(process.env.GANACHE_URL));

// Check if the private key is loaded
if (!process.env.PRIVATE_KEY) {
    console.error("❌ PRIVATE_KEY is missing in .env file.");
    process.exit(1);
}

const account = web3.eth.accounts.privateKeyToAccount(process.env.PRIVATE_KEY);
web3.eth.accounts.wallet.add(account);

// Read compiled contract
const bytecode = fs.readFileSync("contracts/build/IntegerStorage.bin", "utf8");
const abi = JSON.parse(fs.readFileSync("contracts/build/IntegerStorage.abi", "utf8"));

const deployContract = async () => {
    console.log("🚀 Deploying contract to Ganache...");

    const contract = new web3.eth.Contract(abi);
    const deployTx = contract.deploy({ data: "0x" + bytecode });
    const gas = await deployTx.estimateGas({ from: account.address });

    const deployedContract = await deployTx.send({
        from: account.address,
        gas: gas,
    });

    console.log(`✅ Contract deployed at: ${deployedContract.options.address}`);
};

deployContract().catch(console.error);
