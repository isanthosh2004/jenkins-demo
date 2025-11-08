pipleline{
    agent any
    stages{
        stage('checkout'){
            steps{
                echo 'cloning repo....'
                git branch: 'master', url: 'https://github.com/isanthosh2004/jenkins-demo'

            }
        }
        stage('Build'){
            steps{
                echo 'Building the project........'
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test'){
            steps{
                echo 'Running unit tests.....'
                sh 'mvn test'

            }
        }
        stage('Docker Build'){
            steps{
                echo 'building docker image.....'
                sh 'docker build -t jenkins-demo .'
            }
        }
    }
    post{
        success{
            echo ' build completedddddd'

        }
        failure {
            echo 'build unsuccessfullll'
        }
    }
}