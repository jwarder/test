pipeline {
  environment {
    RANCHER_ACCESS_KEY = credentials('RANCHER_ACCESS_KEY')
    RANCHER_SECRET_KEY = credentials('RANCHER_SECRET_KEY')
    RANCHER_URL = 'http://rancher-server.dev.gc.com/'
    DB_URL = 'jdbc:postgresql://experimental.cb60pnrcrtj6.eu-west-1.rds.amazonaws.com:5432/myapp'
    DB_USERNAME = 'postgres'
    DB_PASSWORD = 'password'
  }
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
      steps {
        sh 'rancher-compose -p stack1 up --upgrade -d'
      }
    }
    stage('Database') {
      steps {
        dir(path: '*-database') {
          sh 'pwd'
        }
      }
    }
  }
  tools {
    maven 'apache-maven-3.5.0'
  }
}
