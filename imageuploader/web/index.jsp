<%-- 
    Document   : index
    Created on : May 16, 2019, 3:18:03 PM
    Author     : fhfai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Image Uploader</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <style>
            h1{
                background-color: dimgrey;
                color: white;
                width: 500px;
                padding: 30px;
            }
            fieldset{
                width: 530px;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Profile Registration</h1>
        <fieldset>
            <legend><b>Upload Your Image</b></legend>
            <form action="profile" method="post" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td>Fist Name: </td>
                        <td><input type="text" name="fn" size="25"/></td>
                    </tr>
                    <tr>
                        <td>Last Name: </td>
                        <td><input type="text" name="ln" size="25"/></td>
                    </tr>
                    <tr>
                        <td>Profile Image: </td>
                        <td><input type="file" name="pi" size="25" onchange="previewImage(this)" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <div id="imgcontainer">
                                <img id="preview" src="#" alt="your image"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Done"/> <input type="reset" value="Cancel"/></td>
                    </tr>
                </table>
            </form>
        </fieldset>
    </center>
    <script>
        function previewImage(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#preview')
                            .attr('src', e.target.result)
                            .width(210)
                            .height(150);
                };

                reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
</body>
</html>
