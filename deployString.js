import { ethers } from "ethers";
import fs from "fs";
import dotenv from "dotenv";

dotenv.config();

// Load compiled contract ABI & Bytecode
const abi = JSON.parse(fs.readFileSync("build/StringStorage.abi", "utf8"));
const bytecode = fs.readFileSync("build/StringStorage.bin", "utf8");

async function main() {
    const provider = new ethers.JsonRpcProvider("http://10.71.39.50:8545");
    const wallet = new ethers.Wallet(process.env.PRIVATE_KEY, provider); // Use private key for signing

    // Deploy contract
    const factory = new ethers.ContractFactory(abi, bytecode, wallet);
    const contract = await factory.deploy();
    await contract.waitForDeployment();

    console.log("Contract deployed at:", await contract.getAddress());
}

main().catch(console.error);
