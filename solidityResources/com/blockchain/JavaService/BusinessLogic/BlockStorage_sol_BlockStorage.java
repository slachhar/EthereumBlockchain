package com.blockchain.JavaService.BusinessLogic;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/hyperledger-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.6.2.
 */
@SuppressWarnings("rawtypes")
public class BlockStorage_sol_BlockStorage extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b506101108061001c5f395ff3fe6080604052348015600e575f5ffd5b5060043610603a575f3560e01c806316b9517614603e5780632a1afcd914604f5780633bc5de30146068575b5f5ffd5b604d604936600460c4565b606e565b005b60565f5481565b60405190815260200160405180910390f35b5f546056565b5f811160c05760405162461bcd60e51b815260206004820152601f60248201527f56616c7565206d7573742062652067726561746572207468616e207a65726f00604482015260640160405180910390fd5b5f55565b5f6020828403121560d3575f5ffd5b503591905056fea264697066735822122007903bb07d938724c04108f29ab162abddc1142128e885d53496656a3833e58064736f6c634300081c0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_GETDATA = "getData";

    public static final String FUNC_STOREDATA = "storeData";

    public static final String FUNC_STOREDDATA = "storedData";

    @Deprecated
    protected BlockStorage_sol_BlockStorage(String contractAddress, Web3j web3j,
            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BlockStorage_sol_BlockStorage(String contractAddress, Web3j web3j,
            Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BlockStorage_sol_BlockStorage(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BlockStorage_sol_BlockStorage(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> getData() {
        final Function function = new Function(FUNC_GETDATA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> storeData(BigInteger _value) {
        final Function function = new Function(
                FUNC_STOREDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> storedData() {
        final Function function = new Function(FUNC_STOREDDATA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static BlockStorage_sol_BlockStorage load(String contractAddress, Web3j web3j,
            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BlockStorage_sol_BlockStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BlockStorage_sol_BlockStorage load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BlockStorage_sol_BlockStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BlockStorage_sol_BlockStorage load(String contractAddress, Web3j web3j,
            Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BlockStorage_sol_BlockStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BlockStorage_sol_BlockStorage load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BlockStorage_sol_BlockStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BlockStorage_sol_BlockStorage> deploy(Web3j web3j,
            Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BlockStorage_sol_BlockStorage.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<BlockStorage_sol_BlockStorage> deploy(Web3j web3j,
            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BlockStorage_sol_BlockStorage.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<BlockStorage_sol_BlockStorage> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BlockStorage_sol_BlockStorage.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<BlockStorage_sol_BlockStorage> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BlockStorage_sol_BlockStorage.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
