pipeline {
    agent any

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