# Use an official Node.js runtime as the base image
FROM node:16-alpine

# Set the working directory
WORKDIR /app

# Copy the package.json and package-lock.json files
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application files
COPY . .

# Expose port for the app (optional)
EXPOSE 3000

# Set environment variables if needed (for Ganache URL or others)
ENV GANACHE_URL=http://ganache:8545

# Run the deployment script
CMD ["node", "deploy.js"]
