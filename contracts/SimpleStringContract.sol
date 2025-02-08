// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract SimpleStringContract {
    string[] public storedStrings;

    event StringStored(string newValue);

    function storeString(string memory _newValue) public {
        storedStrings.push(_newValue);
        emit StringStored(_newValue);
    }

    function getAllStrings() public view returns (string[] memory) {
        return storedStrings;
    }
}
