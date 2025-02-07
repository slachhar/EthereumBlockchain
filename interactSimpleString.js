import { ethers } from "hardhat";
import dotenv from "dotenv";

dotenv.config();

async function main() {
    const contractAddress = "0x06a85cBF109f16386Cb9eFbeE4ce87547BB8fbD6";
    const StringStorage = await ethers.getContractFactory("StringStorage");
    const provider = new ethers.JsonRpcProvider("http://127.0.0.1:8545");
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
