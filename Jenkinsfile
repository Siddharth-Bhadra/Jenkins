pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                // Clone the code from Git
                git branch: 'main', url: 'https://github.com/Siddharth-Bhadra/Jenkins.git'
            }
        }
        stage('Build') {
            steps {
                // Command to build your website (replace as necessary)
                sh './build.sh' // For Java
            }
        }
        stage('Test') {
            steps {
                // Run tests (if any)
                sh 'java tests/' // For Python
            }
        }
        stage('Deploy') {
            steps {
                // Deploy the website (you can deploy to VM or any hosting service)
             sh 'dependency-check --scan ./ --out report'
            }
        }
    }
}
