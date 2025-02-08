// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract SimpleStringStorage {
    string public storedString;

    // Store a new string
    function storeString(string memory _newString) public {
        storedString = _newString;
    }

    // Get the stored string
    function getStoredString() public view returns (string memory) {
        return storedString;
    }
}
