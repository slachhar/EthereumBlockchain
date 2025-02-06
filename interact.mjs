import dotenv from "dotenv";
import Web3 from "web3";
import fs from "fs";

dotenv.config();

if (!process.env.GANACHE_URL) {
    console.error("❌ GANACHE_URL is not set. Check your .env file.");
    process.exit(1);
}

// Connect to Ganache (ensure the variable is correctly read)
console.log(`🔗 Connecting to Ganache at: ${process.env.GANACHE_URL}`);
const web3 = new Web3(new Web3.providers.HttpProvider(process.env.GANACHE_URL));

const contractAddress = "0x9208e2025f6b833f4e68ea05FE4C34Ac3db374eA";
const abi = JSON.parse(fs.readFileSync("contracts/build/IntegerStorage.abi", "utf8"));


const account = web3.eth.accounts.privateKeyToAccount(process.env.PRIVATE_KEY);
web3.eth.accounts.wallet.add(account);
// Load the deployed contract
const contract = new web3.eth.Contract(abi, process.env.CONTRACT_ADDRESS);

const interactWithContract = async () => {
    try {
        console.log("🚀 Interacting with contract at:", process.env.CONTRACT_ADDRESS);

        // Store an integer in the contract
        console.log("📝 Storing integer 42...");
        await contract.methods.storeInteger(42).send({
            from: account.address,
            gas: 500000
        });
        console.log("✅ Integer stored successfully!");

        // Retrieve all stored integers
        console.log("📜 Fetching stored integers...");
        const storedValues = await contract.methods.getAllStoredValues().call();
        console.log("✅ Stored Values:", storedValues);

    } catch (error) {
        console.error("❌ Error interacting with contract:", error);
    }
};

interactWithContract();