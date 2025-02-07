package com.blockchain;

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
public class BlockStorage extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b5061022b8061001c5f395ff3fe608060405234801561000f575f5ffd5b506004361061003f575f3560e01c806316b95176146100435780632a1afcd91461005f5780633bc5de301461007d575b5f5ffd5b61005d6004803603810190610058919061012a565b61009b565b005b6100676100e6565b6040516100749190610164565b60405180910390f35b6100856100eb565b6040516100929190610164565b60405180910390f35b5f81116100dd576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016100d4906101d7565b60405180910390fd5b805f8190555050565b5f5481565b5f5f54905090565b5f5ffd5b5f819050919050565b610109816100f7565b8114610113575f5ffd5b50565b5f8135905061012481610100565b92915050565b5f6020828403121561013f5761013e6100f3565b5b5f61014c84828501610116565b91505092915050565b61015e816100f7565b82525050565b5f6020820190506101775f830184610155565b92915050565b5f82825260208201905092915050565b7f56616c7565206d7573742062652067726561746572207468616e207a65726f005f82015250565b5f6101c1601f8361017d565b91506101cc8261018d565b602082019050919050565b5f6020820190508181035f8301526101ee816101b5565b905091905056fea2646970667358221220bf49b0cebab53cc925f41c6b96d2387808d9a1a249ba30f36b600bd0686c84ad64736f6c634300081c0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_GETDATA = "getData";

    public static final String FUNC_STOREDATA = "storeData";

    public static final String FUNC_STOREDDATA = "storedData";

    @Deprecated
    protected BlockStorage(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BlockStorage(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BlockStorage(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BlockStorage(String contractAddress, Web3j web3j,
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
    public static BlockStorage load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new BlockStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BlockStorage load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BlockStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BlockStorage load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new BlockStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BlockStorage load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BlockStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BlockStorage> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BlockStorage.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<BlockStorage> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BlockStorage.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<BlockStorage> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BlockStorage.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<BlockStorage> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BlockStorage.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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
