pipeline {
    agent any
       environment {
            LC_ALL = 'en_US.UTF-8'
            LANG    = 'en_US.UTF-8'
            LANGUAGE = 'en_US.UTF-8'
        }
    tools {
        maven 'MAVEN_HOME'
    }

    triggers {
        githubPush()
    }

    parameters {
        string(name: 'GIT_URL', defaultValue: 'https://github.com/AlenaUslontseva/otus_final_prodject', description: 'The target git url')
        string(name: 'GIT_BRANCH', defaultValue: 'master', description: 'The target git branch')
        string(name: 'EMAIL_NOTIFICATION', defaultValue: 'auslonceva@ya.ru', description: 'default email')
        string(name: 'REMOTE_URL', defaultValue: 'http://selenoid:4444/wd/hub', description: 'Selenoid url')
        choice(name: 'BROWSER_NAME', choices: ['chrome', 'firefox'], description: 'Pick the target browser in Selenoid')
        choice(name: 'BROWSER_VERSION', choices: ['89.0', '88.0', '78.0'], description: 'Pick the target browser version in Selenoid')
    }
    stages {
   stage('Pull from GitHub') {
            steps {
                git ([
                    url: "${params.GIT_URL}",
                    branch: "${params.GIT_BRANCH}"
                    ])
            }
        }
        stage('Run maven clean test') {
            steps {
                bat 'mvn clean test -Dbrowser_name=$BROWSER_NAME -Dbrowser_version=$BROWSER_VERSION'
            }

        }
        stage('Backup and Reports') {
            steps {
                archiveArtifacts artifacts: '**/target/', fingerprint: true
            }
            post {
                always {
                  script {
                     // Узнаем ветку репозитория
                      def branch = bat(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD\n').trim().tokenize().last()
                      println("branch= " + branch)
                      // Достаем информацию по тестам из junit репорта
                      def summary = junit testResults: '**/target/surefire-reports/*.xml'
                      println("summary generated")
                      // Текст оповещения
                      def message = "${currentBuild.currentResult}: Job ${env.JOB_NAME}, build ${env.BUILD_NUMBER}, branch ${branch}\nTest Summary - ${summary.totalCount}, Failures: ${summary.failCount}, Skipped: ${summary.skipCount}, Passed: ${summary.passCount}\nMore info at: ${env.BUILD_URL}"
                      if (currentBuild.currentResult == 'SUCCESS') {
                      step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: "auslonceva@ya.ru", sendToIndividuals: true])
                      } else {
                     step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: "auslonceva@ya.ru", sendToIndividuals: true])
                            }


                    // Формирование отчета allure
                      allure([
                      includeProperties: false,
                      jdk: '',
                      properties: [],
                      reportBuildPolicy: 'ALWAYS',
                      results: [[path: 'target/allure-results']]
                    ])
                    println('allure report created')


                    println("message= " + message)
                  }

                }

            }
        }
    }
}