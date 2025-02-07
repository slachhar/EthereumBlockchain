import dotenv from "dotenv";
import Web3 from "web3";
import fs from "fs";

// Load environment variables
dotenv.config();

// Connect to Ganache
const web3 = new Web3(new Web3.providers.HttpProvider(process.env.GANACHE_URL));

// Load private key and create account
const account = web3.eth.accounts.privateKeyToAccount(process.env.PRIVATE_KEY);
web3.eth.accounts.wallet.add(account);

// Read contract ABI
const abi = JSON.parse(fs.readFileSync("build/SimpleStringContract.abi", "utf8"));
const contract = new web3.eth.Contract(abi, process.env.CONTRACT_ADDRESS);

const interactWithContract = async () => {
    try {
        console.log("🚀 Interacting with contract at:", process.env.CONTRACT_ADDRESS);

        const test = await contract.methods.getAllStoredStrings().call();
        console.log("Stored Strings:", test);

        // Store a long string in the contract
        const longString = "a";

        console.log(`📝 Storing long string: ${longString}`);
        await contract.methods.storeString("a").send({
            from: account.address,
            gas: 4000000,
        });
        console.log("✅ String stored successfully!");

        // Retrieve all stored strings
        console.log("📜 Fetching stored strings...");
        const storedCount = await contract.methods.getAllStoredStrings().call();
        if (storedCount.length === 0) {
            console.log("❌ No stored values yet.");
        } else {
            console.log("✅ Stored strings:", storedCount);
        }

        const storedStrings = await contract.methods.getAllStoredStrings().call();
        console.log("✅ Stored Strings:", storedStrings);

    } catch (error) {
        console.error("❌ Error interacting with contract:", error);
    }
};

interactWithContract();
