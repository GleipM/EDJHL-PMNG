pipeline{
    agent any
    enviroment{
        COMPOSE_PROJECT_NAME = 'pmng'
        COMPOSE_FILE = 'docker-compose.yml'
        ENV-FILE = credentials('pmng-env')
    }
    stages{
        stage('Parar servicios'){
            steps {
                echo 'Deteniendo contenedores...'
                sh '''
                    docker compose -p ${COMPOSE_PROJECT_NAME} -f {COMPOSE_FILE} --env-file ${ENV-FILE} down || true

                '''
            }
        }
        stage('Eliminar imagenes'){
            steps{
                echo 'Eliminando imagenes antiguas...'
                sh '''
                    IMAGES = $(
                        docker compose -p ${COMPOSE_PROJECT_NAME} -f {COMPOSE_FILE} --env-file ${ENV-FILE} config --images| sort -u
                        )

                    for IMAGE in $IMAGES; do
                        echo "Eliminando imagen $IMAGE"
                        docker rmi "$IMAGE" || true
                    done 
                '''
            }
        }
        stage('Construir imagenes'){
            steps{
                echo 'Generando nuevas imagenes'
                sh '''
                    docker compose -p ${COMPOSE_PROJECT_NAME} -f {COMPOSE_FILE} --env-file ${ENV-FILE} --no-cache
                '''
        }
        stage('levantar servicios'){
            steps{
                echo 'Generando contenedores'
                sh '''
                    docker compose -p ${COMPOSE_PROJECT_NAME} -f {COMPOSE_FILE} --env-file ${ENV-FILE} up -d --force-recreate
                '''
            }
        }
    }
    post{
        succes {
            echo 'Construccion del proyecto exitosa'
        }
        failure {
            echo 'Ecurrio un error en la contruccion del proyecto' 
        }
        
    }

    }
}