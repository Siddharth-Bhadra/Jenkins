pipeline {
    agent any

     tools {
        // Use the correct JDK version configured in Jenkins
        jdk 'jdk-17.0.12'  // Adjust to match your configuration
    }

    environment {
        // SSH credentials and target details
        KALI_USER = 'kali'  // SSH user for Kali Linux VM
        KALI_VM_IP = '10.0.2.7'  // IP address of Kali Linux VM
        TARGET_URL = 'http://localhost:8080'  // Local app running on Jenkins VM
        ZAP_REPORT = 'zap-report.html'  // ZAP report file name
    }
    
    stages {
        stage('Clone Repository') {
            steps {
                // Clone the code from Git
                git branch: 'main', url: 'https://github.com/Siddharth-Bhadra/Jenkins.git'
            }
        }

    stage('Compile') {
        steps {
                // Compile the Java file
                sh 'javac App.java'
            }
        }
    stage('Run Application Locally on Jenkins') {
        steps {
                // Run the Java application on port 8080 on Jenkins (Ubuntu VM)
                sh 'nohup java App'
            }
        }
    stage('Run OWASP ZAP on Kali Linux VM') {
        steps {
            script {
                    // SSH into Kali Linux VM and start OWASP ZAP in headless mode
                    sh '''
                    #!/bin/bash
                    ssh -i /var/lib/jenkins/.ssh/id_rsa  -o StrictHostKeyChecking=no kali@10.0.2.7 "zaproxy -daemon -host 127.0.0.1 -port 8080"
                    ssh -i /var/lib/jenkins/.ssh/id_rsa  -o StrictHostKeyChecking=no kali@10.0.2.7 "zap-baseline.py -t ${TARGET_URL} -r ${ZAP_REPORT} -d"
                    '''
                }
            }
        }
     stages {
        stage('Run OWASP ZAP Baseline Scan') {
            steps {
                script {
                    // SSH into Kali Linux VM and run the ZAP baseline scan
                    sh '''
                    ssh -i /var/lib/jenkins/.ssh/id_rsa  -o StrictHostKeyChecking=no kali@10.0.2.7 "/usr/share/zaproxy/zap-baseline.py -t ${TARGET_URL} -r ${ZAP_REPORT} -d"
                    '''
                }
            }
        }

    stage('Retrieve ZAP Report from Kali VM') {
        steps {
            script {
                    // Retrieve the ZAP report from Kali Linux VM to Jenkins (Ubuntu VM)
                    sh '''
                    #!/bin/bash
                    scp -i /var/lib/jenkins/.ssh/id_rsa  -o StrictHostKeyChecking=no kali@10.0.2.7:${ZAP_REPORT} .
                    '''
                }
            }
        }


    stage('Publish ZAP Report') {
        steps {
                // Publish the ZAP DAST report in Jenkins
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: '.', reportFiles: '${ZAP_REPORT}', reportName: 'OWASP ZAP DAST Report'])
                }
            }


  //        stage('Run Application') {
  //          steps {
  //              // Run the compiled Java class
  //              sh 'java -cp . App'
  //          }
   //    }

        
    stage('Test') {
            steps {
                // If you have tests, you can add test steps here
                echo 'No tests to run for now'
            }
        }
    
    post {
        always {
            // Clean up or send notifications, if required
            echo 'Pipeline completed'
        }
        success {
            echo 'OWASP ZAP scan completed successfully'
        }
        failure {
            echo 'OWASP ZAP scan  failed'
        }
    }
}
