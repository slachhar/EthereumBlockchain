#
##
docker build -t blockchain-app .  # This command use Dockerfile

docker-compose up --build # This command use docker-compose.yml file

how to fix below error:
Error interacting with contract: TransactionRevertedWithoutReasonError: Transaction has been reverted by the EVM:
: something wrong with abi file or try simpler code

Error interacting with contract: InvalidResponseError: Returned error: VM Exception while processing transaction: invalid opcode
::redeploy code

Things to do when tying to deploy contract on ganache on docker on VM:

try to hit ganchae url through postman:
POST: http://10.71.39.50:8545
{
"jsonrpc": "2.0",
"method": "eth_blockNumber",
"params": [],
"id": 1
}

docker-compose build
docker-compose up

Docker Compose Needs to Run on the Host VM: The docker-compose.yml file defines how Docker containers should be built and run. This file must be present on the host machine (in this case, the VM). If you want to run Ganache as a Docker container, you will define the service in this file.

You Can't Run docker-compose Remotely: If you're working from your local machine, you won't be able to directly use docker-compose commands for containers running on the VM unless the VM is set up to accept Docker commands remotely. However, typically, Docker and Docker Compose commands should be executed directly on the VM where Docker is running.


running solc in docker image
- docker run ethereum/solc:stable --help  //install docker container for solc
- docker run --rm -v /home/shefali/EthereumBlockchain:/workspace ethereum/solc:stable --optimize --bin --abi --overwrite -o /workspace/build /workspace/contracts/StringStorage.sol // put contract in solc container and compile it
- the compiled files will go in build folder
