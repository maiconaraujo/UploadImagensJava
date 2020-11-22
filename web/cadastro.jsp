<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Busca Tech</title>        
    </head>

    <body>
        <form id="formImagem" name="formImagem" method="post" action="servletupload" enctype="multipart/form-data">
            <input type="hidden" id="tipoForm" name="tipoForm" value="imagem">
            <input name="imagem" type="file" accept="image/jpeg; image/gif; image/bmp; image/png" 
                   id="imagem" >           

            <input type="submit" value="enviar" >
        </form>
    </body>
</html>
