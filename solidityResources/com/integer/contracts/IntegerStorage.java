package solidityResources.com.integer.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
public class IntegerStorage extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b506103c78061001c5f395ff3fe608060405234801561000f575f5ffd5b506004361061003f575f3560e01c8063319120aa146100435780636d7638e814610073578063e4ac3fae14610091575b5f5ffd5b61005d600480360381019061005891906101ef565b6100ad565b60405161006a9190610229565b60405180910390f35b61007b6100cc565b60405161008891906102f9565b60405180910390f35b6100ab60048036038101906100a691906101ef565b610121565b005b5f81815481106100bb575f80fd5b905f5260205f20015f915090505481565b60605f80548060200260200160405190810160405280929190818152602001828054801561011757602002820191905f5260205f20905b815481526020019060010190808311610103575b5050505050905090565b5f8111610163576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161015a90610373565b60405180910390fd5b5f81908060018154018082558091505060019003905f5260205f20015f9091909190915055807fb3e847b209d7e23c3fea7be796f2768c4f7572f929d4bb20911d520050e766d860405160405180910390a250565b5f5ffd5b5f819050919050565b6101ce816101bc565b81146101d8575f5ffd5b50565b5f813590506101e9816101c5565b92915050565b5f60208284031215610204576102036101b8565b5b5f610211848285016101db565b91505092915050565b610223816101bc565b82525050565b5f60208201905061023c5f83018461021a565b92915050565b5f81519050919050565b5f82825260208201905092915050565b5f819050602082019050919050565b610274816101bc565b82525050565b5f610285838361026b565b60208301905092915050565b5f602082019050919050565b5f6102a782610242565b6102b1818561024c565b93506102bc8361025c565b805f5b838110156102ec5781516102d3888261027a565b97506102de83610291565b9250506001810190506102bf565b5085935050505092915050565b5f6020820190508181035f830152610311818461029d565b905092915050565b5f82825260208201905092915050565b7f56616c7565206d7573742062652067726561746572207468616e207a65726f005f82015250565b5f61035d601f83610319565b915061036882610329565b602082019050919050565b5f6020820190508181035f83015261038a81610351565b905091905056fea2646970667358221220ed462cd627b1a69c1223903472ce7c0778afb2744d06ca0f89118eb8b2b0eea464736f6c634300081c0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_GETALLSTOREDVALUES = "getAllStoredValues";

    public static final String FUNC_STOREINTEGER = "storeInteger";

    public static final String FUNC_STOREDINTEGERS = "storedIntegers";

    public static final Event INTEGERSTORED_EVENT = new Event("IntegerStored", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected IntegerStorage(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IntegerStorage(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IntegerStorage(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IntegerStorage(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<IntegerStoredEventResponse> getIntegerStoredEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(INTEGERSTORED_EVENT, transactionReceipt);
        ArrayList<IntegerStoredEventResponse> responses = new ArrayList<IntegerStoredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            IntegerStoredEventResponse typedResponse = new IntegerStoredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.value = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static IntegerStoredEventResponse getIntegerStoredEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(INTEGERSTORED_EVENT, log);
        IntegerStoredEventResponse typedResponse = new IntegerStoredEventResponse();
        typedResponse.log = log;
        typedResponse.value = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<IntegerStoredEventResponse> integerStoredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getIntegerStoredEventFromLog(log));
    }

    public Flowable<IntegerStoredEventResponse> integerStoredEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INTEGERSTORED_EVENT));
        return integerStoredEventFlowable(filter);
    }

    public RemoteFunctionCall<List> getAllStoredValues() {
        final Function function = new Function(FUNC_GETALLSTOREDVALUES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> storeInteger(BigInteger _value) {
        final Function function = new Function(
                FUNC_STOREINTEGER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> storedIntegers(BigInteger param0) {
        final Function function = new Function(FUNC_STOREDINTEGERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static IntegerStorage load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new IntegerStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IntegerStorage load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IntegerStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IntegerStorage load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new IntegerStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IntegerStorage load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IntegerStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IntegerStorage> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IntegerStorage.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<IntegerStorage> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IntegerStorage.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<IntegerStorage> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IntegerStorage.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<IntegerStorage> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IntegerStorage.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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

    public static class IntegerStoredEventResponse extends BaseEventResponse {
        public BigInteger value;
    }
}
