import Web3 from "web3";
import fs from "fs";
import dotenv from "dotenv";

dotenv.config();

const provider = new Web3.providers.HttpProvider(process.env.GANACHE_URL);
const web3 = new Web3(provider);

const abi = JSON.parse(fs.readFileSync("./build/SimpleStringStorage.abi", "utf8"));
const contractAddress = process.env.CONTRACT_ADDRESS;
const contract = new web3.eth.Contract(abi, contractAddress);

// Add account from private key
const account = web3.eth.accounts.wallet.add(process.env.PRIVATE_KEY);

// Store a new string
const storeString = async (newString) => {
  try {
    console.log(`í ½íº€ Storing string: "${newString}"...`);

    const receipt = await contract.methods.storeString(newString).send({
      from: account.address, // Use the address from the account
      gas: 3000000,
    });

    console.log("âœ… String stored successfully. Transaction receipt:", receipt);
  } catch (error) {
    console.error("âŒ Error storing string:", error);
  }
};

// Retrieve stored string
const getStoredString = async () => {
  try {
    console.log("í ½í´ Fetching stored string...");
    const storedString = await contract.methods.getStoredString().call();
    console.log("âœ… Stored String:", storedString);
  } catch (error) {
    console.error("âŒ Error fetching string:", error);
  }
};

(async () => {
  await storeString("Hello, Blockchain!");
  await getStoredString();
})();
