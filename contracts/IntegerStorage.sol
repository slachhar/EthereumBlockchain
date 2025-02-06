// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract IntegerStorage {
    uint256[] public storedIntegers;

    event IntegerStored(uint256 indexed value);

    function storeInteger(uint256 _value) public {
        require(_value > 0, "Value must be greater than zero");
        storedIntegers.push(_value);
        emit IntegerStored(_value);
    }

    function getAllStoredValues() public view returns (uint256[] memory) {
        return storedIntegers;
    }
}
