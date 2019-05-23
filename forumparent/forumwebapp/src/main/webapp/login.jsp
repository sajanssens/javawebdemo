<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-4">
    <div class="jumbotron">
        <h1>Login</h1>
        <p class="lead">In today's world internet is the most popular way of connecting with people. At this course
            you will learn the essential Java web development technologies along with real life practice examples, so
            that you can create your own webapp to connect with the people around the world!</p>
        <p>
            <a href="https://www.infosupport.com" target="_blank" class="btn btn-success btn-lg">Get started today</a>
        </p>
    </div>
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form action="j_security_check" method=post>
                <div class="form-group row">
                    <label for="username" class="col-sm-4 col-form-label">Username</label>
                    <div class="col-sm-8">
                        <input type="text" name="j_username" class="form-control" id="username" placeholder="Username">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-sm-4 col-form-label">Password</label>
                    <div class="col-sm-8">
                        <input type="password" name="j_password" class="form-control" id="password" placeholder="Password">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-8 offset-sm-4">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</body>
</html>