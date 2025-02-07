// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BlockStorage {
    uint256 public storedData;

// Event for logging actions
    event intStored(uint256 indexed storedData);

    function storeData(uint256 _value) public {
        require(_value > 0, "Value must be greater than zero");
        storedData = _value;

        emit intStored(_value); // Emit event for transparency
    }

    function getData() public view returns (uint256) {
        return storedData;
    }
}
