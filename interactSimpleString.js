import { ethers } from "ethers";
import dotenv from "dotenv";

dotenv.config();

async function main() {
    const contractAddress = "0x32fd0ba6aedF75C114945CF58Ea88e37C6112D3a";
    const StringStorage = await ethers.getContractFactory("StringStorage");
    const provider = new ethers.JsonRpcProvider("http://10.71.39.50:8545");
    const signer = provider.getSigner(0);
    const contract = new ethers.Contract(contractAddress, StringStorage.interface, signer);

    // Storing a string
    const tx = await contract.storeString("Hello, Blockchain!");
    await tx.wait();
    console.log("Stored a new string!");

    // Fetching all stored strings
    const allStrings = await contract.getAllStrings();
    console.log("All stored strings:", allStrings);
}

main().catch((error) => {
    console.error(error);
    process.exit(1);
});
