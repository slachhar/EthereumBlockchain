import solc from "solc";
import fs from "fs";
import path from "path";

const contractPath = path.resolve("contracts", "SimpleStringStorage.sol");
const source = fs.readFileSync(contractPath, "utf8");

const input = {
  language: "Solidity",
  sources: {
    "SimpleStringStorage.sol": { content: source },
  },
  settings: { outputSelection: { "*": { "*": ["abi", "evm.bytecode"] } } },
};

// Compile contract
const compiledContract = JSON.parse(solc.compile(JSON.stringify(input)));

// Save ABI & Bytecode
const contractName = "SimpleStringStorage";
const contractData = compiledContract.contracts["SimpleStringStorage.sol"][contractName];

fs.writeFileSync("./build/SimpleStringStorage.abi", JSON.stringify(contractData.abi));
fs.writeFileSync("./build/SimpleStringStorage.bin", contractData.evm.bytecode.object);

console.log("✅ Compilation successful. ABI and Bytecode saved.");
