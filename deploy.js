import Web3 from 'web3';
import fs from 'fs-extra';
import path from 'path';
import { fileURLToPath } from 'url';
import { dirname } from 'path';

// Resolve __dirname for ES Modules
const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);

// Connect to Ganache (Docker)
const web3 = new Web3('http://127.0.0.1:7545');

// Load compiled contract
const contractJsonPath = path.resolve(__dirname, 'build', 'BlockStorage.json');
console.log("🔍 Reading compiled contract from:", contractJsonPath);

const contractJson = JSON.parse(fs.readFileSync(contractJsonPath, 'utf8'));

// Ensure contract contains bytecode
if (!contractJson.evm || !contractJson.evm.bytecode.object) {
    console.error("❌ Error: Bytecode not found in compiled contract!");
    process.exit(1);
}

const bytecode = contractJson.evm.bytecode.object;
const abi = contractJson.abi;

// Deploy contract
const deploy = async () => {
    const accounts = await web3.eth.getAccounts();
    console.log("📜 Deploying from account:", accounts[0]);

    const contract = new web3.eth.Contract(abi);
    const deployedContract = await contract.deploy({ data: bytecode,  arguments: [42] }).send({
        from: accounts[0],
        gas: 500000,
        gasPrice: await web3.eth.getGasPrice()  // ✅ Use legacy gas pricing
    });

    console.log("✅ Contract deployed at:", deployedContract.options.address);
    fs.writeFileSync('contract-address.txt', deployedContract.options.address);
};

deploy().catch(err => console.error("❌ Deployment failed:", err));
