pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn install -Dmaven.test.failure.ignore=true install'
      }
    }
    stage('Report') {
      steps {
        junit '**/target/surefire-reports/*.xml'
      }
    }
    stage('Package') {
      when {
        expression {
          currentBuild.result == null || currentBuild.result == 'SUCCESS'
        }

      }
      steps {
        sh 'mvn docker:build -DpushImage'
      }
    }
    stage('Integration') {
      environment {
        ACCESS_KEY = credentials('RANCHER_ACCESS_KEY')
      }
      steps {
        sh 'printenv'
      }
    }
  }
  tools {
    maven 'apache-maven-3.5.0'
  }
}
