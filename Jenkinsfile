pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                // Clone the code from Git
                git branch: 'main', url: 'https://github.com/your-repo-url.git'
            }
        }
        stage('Build') {
            steps {
                // Command to build your website (replace as necessary)
                sh 'npm install' // or any other build command based on your tech stack
            }
        }
        stage('Test') {
            steps {
                // Run tests (if any)
                sh 'npm test' // or any other test command
            }
        }
        stage('Deploy') {
            steps {
                // Deploy the website (you can deploy to VM or any hosting service)
                sh 'scp -r ./build user@targetVM:/var/www/html' // Example for static websites
            }
        }
    }
}
