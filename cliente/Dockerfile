#Que imagen base ocuparé
FROM nginx:alpine


#Eliminamos los archivos por defecto en la imagen por defecto
RUN rm -rf /usr/share/nginx/html/*


#Copiamos los archivos de nuestro proyecto a la imagen
COPY . /usr/share/nginx/html


#Deciren que puerto se va a exponer la aplicación
EXPOSE 80