// trigger test comment
pipeline {
    agent any

    environment {
        MAVEN_CMD = 'D:/maven/bin/mvn.cmd'
        JAVA_HOME = 'C:\\Program Files\\Eclipse Adoptium\\jdk-17.0.20.101-hotspot'
        PATH = "${env.JAVA_HOME}\\bin;D:\\maven\\bin;${env.PATH}"
    }
        
    parameters {
        string(name: 'DELIVERY_NOTE', defaultValue: 'Standard Delivery', description: 'Комментарий к доставке')
    }

    stages {
        stage('Build') {
            steps {
                bat "echo === Delivery Note: ${params.DELIVERY_NOTE} ==="
                bat 'D:\\maven\\bin\\mvn.cmd compile'
            }
        }
        stage('Test') {
            steps {
                bat 'D:\\maven\\bin\\mvn.cmd test'
            }
        }
        stage('Package') {
            steps {
                bat 'D:\\maven\\bin\\mvn.cmd package -DskipTests'
            }
        }
    }
}
