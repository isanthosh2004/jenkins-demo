pipeline {
    agent any

    tools {
        maven 'Maven_3.9.6'
        jdk 'JDK_17'
    }

    environment {
        IMAGE_NAME = 'jenkins-demo'
        CONTAINER_NAME = 'jenkins-demo-container'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning repository...'
                git branch: 'master', url: 'https://github.com/isanthosh2004/jenkins-demo.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests...'
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Building Docker image...'
                sh "docker build -t ${IMAGE_NAME}:latest ."
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying Docker container...'
                // Stop if already running
                sh "docker ps -q --filter name=${CONTAINER_NAME} | grep -q . && docker stop ${CONTAINER_NAME} || true"
                sh "docker ps -a -q --filter name=${CONTAINER_NAME} | grep -q . && docker rm ${CONTAINER_NAME} || true"

                // Run new container
                sh "docker run -d -p 8081:8080 --name ${CONTAINER_NAME} ${IMAGE_NAME}:latest"
            }
        }
    }

    post {
        success {
            echo '🎉 Build and Deployment Successful!'
        }
        failure {
            echo '❌ Build or Deploy failed!'
        }
    }
}
