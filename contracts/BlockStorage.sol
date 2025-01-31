// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BlockStorage {
    uint256 public storedData;

    function storeData(uint256 _value) public {
        require(_value > 0, "Value must be greater than zero");
        storedData = _value;
    }

    function getData() public view returns (uint256) {
        return storedData;
    }
}
