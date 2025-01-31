import solc from 'solc';
import fs from 'fs-extra';
import path from 'path';
import { fileURLToPath } from 'url';
import { dirname } from 'path';

// Resolve __dirname for ES Modules
const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);

// Path to contract
const contractPath = path.resolve(__dirname, 'contracts', 'BlockStorage.sol');
const source = fs.readFileSync(contractPath, 'utf8');

// Solidity compiler input format
const input = {
    language: 'Solidity',
    sources: {
        'BlockStorage.sol': { content: source }
    },
    settings: {
        optimizer: { enabled: true, runs: 200 },  // Optimize bytecode
        outputSelection: { '*': { '*': ['abi', 'evm.bytecode'] } }  // ✅ Request ABI & bytecode
    }
};

// Compile contract
const output = JSON.parse(solc.compile(JSON.stringify(input)));

// Extract compiled contract
const contractName = 'BlockStorage';  // Replace with actual contract name
const compiledContract = output.contracts['BlockStorage.sol'][contractName];

if (!compiledContract || !compiledContract.evm || !compiledContract.evm.bytecode.object) {
    console.error("❌ Compilation failed! No bytecode found.");
    process.exit(1);
}

// Create build folder
const buildPath = path.resolve(__dirname, 'build');
fs.ensureDirSync(buildPath);

// Save ABI & Bytecode to JSON file
const contractJsonPath = path.resolve(buildPath, 'BlockStorage.json');
fs.writeFileSync(contractJsonPath, JSON.stringify(compiledContract, null, 2));

console.log("✅ Compilation successful! ABI & Bytecode saved.");
