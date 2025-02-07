// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StringStorage {
    string[] public storedStrings; // Array to store long strings

    event StringStored(uint256 indexed id, string value);

    function storeString(string memory _value) public {
        require(bytes(_value).length > 0, "String cannot be empty");
        storedStrings.push(_value);
        emit StringStored(storedStrings.length - 1, _value);
    }

    function getAllStoredStrings() public view returns (string[] memory) {
        return storedStrings;
    }

    function getStringByIndex(uint256 index) public view returns (string memory) {
        require(index < storedStrings.length, "Index out of bounds");
        return storedStrings[index];
    }
}
