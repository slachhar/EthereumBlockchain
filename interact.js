import Web3 from 'web3';
import fs from 'fs-extra';
import path from 'path';
import { fileURLToPath } from 'url';
import { dirname } from 'path';

// Resolve paths for ES Modules
const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);

//const providerUrl = "http://127.0.0.1:8545";
//const providerUrl = "http://0.0.0.0:7545";
//const web3 = new Web3(providerUrl);
const web3 = new Web3(process.env.GANACHE_URL || 'http://127.0.0.1:8545');  // Change 'localhost' to the correct address if in Docker.


// Load ABI & Contract Address
const contractJsonPath = path.resolve(__dirname, 'build', 'BlockStorage.json');
const contractJson = JSON.parse(fs.readFileSync(contractJsonPath, 'utf8'));
const abi = contractJson.abi;

const contractAddress = fs.readFileSync(path.resolve(__dirname, 'contract-address.txt'), 'utf8').trim();
const contract = new web3.eth.Contract(abi, contractAddress);

const interact = async () => {
    try {
        const accounts = await web3.eth.getAccounts();
        console.log("Using account:", accounts[0]);

        // Store data in contract
        const tx = await contract.methods.storeData(50).send({ from: accounts[0], gas: 3000000 });
        console.log("✅ Transaction successful:", tx.transactionHash);

        // Retrieve stored data
        const storedValue = await contract.methods.getData().call();
        console.log("📦 Stored Data:", storedValue);
    } catch (error) {
        console.error("❌ Interaction failed:", error);
    }
};

interact();
