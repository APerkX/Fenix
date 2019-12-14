pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Ciao mondo'
      }
    }
    stage('Unit Test') {
      steps {
        sh 'mvn test'
      }
    }
  }
}