# Use official Node.js image as base
FROM node:16

# Create and set working directory
#WORKDIR /app

# Copy package.json and package-lock.json for installing dependencies
COPY package*.json ./

# Install dependencies
#RUN npm install

# Copy the rest of the application code
COPY . .

# Set environment variables
ENV RPC_URL=http://10.71.39.50:8545

# Set default command to run the deploy script
CMD ["node", "deploy.mjs"]