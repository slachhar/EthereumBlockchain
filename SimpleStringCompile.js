import solc from "solc";
import fs from "fs";
import path from "path";

const contractPath = path.resolve("contracts", "SimpleStringContract.sol");
const source = fs.readFileSync(contractPath, "utf8");

const input = {
  language: "Solidity",
  sources: {
    "SimpleStringContract.sol": { content: source },
  },
  settings: { outputSelection: { "*": { "*": ["abi", "evm.bytecode"] } } },
};

// Compile contract
const compiledContract = JSON.parse(solc.compile(JSON.stringify(input)));

// Save ABI & Bytecode
const contractName = "SimpleStringContract";
const contractData = compiledContract.contracts["SimpleStringContract.sol"][contractName];

fs.writeFileSync("./build/SimpleStringContract.abi", JSON.stringify(contractData.abi));
fs.writeFileSync("./build/StringStringContract.bin", contractData.evm.bytecode.object);

console.log("✅ Compilation successful. ABI and Bytecode saved.");
