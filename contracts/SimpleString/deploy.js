import Web3 from "web3";
import fs from "fs";
import dotenv from "dotenv";

dotenv.config();

const provider = new Web3.providers.HttpProvider(process.env.GANACHE_URL);
const web3 = new Web3(provider);

const abi = JSON.parse(fs.readFileSync("./build/SimpleStringStorage.abi", "utf8"));
const bytecode = "0x" + fs.readFileSync("./build/SimpleStringStorage.bin", "utf8");

const deployContract = async () => {
  try {
    const accounts = await web3.eth.getAccounts(); // Get available accounts
    const deployer = accounts[0]; // Use the first account

    console.log(`🚀 Deploying contract from: ${deployer}`);

    const contract = new web3.eth.Contract(abi);
    const deployedContract = await contract
      .deploy({ data: bytecode })
      .send({ from: deployer, gas: 3000000 });

    console.log(`✅ Contract deployed at: ${deployedContract.options.address}`);

    // Save the deployed contract address
    fs.writeFileSync("./.env", `CONTRACT_ADDRESS="${deployedContract.options.address}"`);
  } catch (error) {
    console.error("❌ Deployment failed:", error);
  }
};

deployContract();
