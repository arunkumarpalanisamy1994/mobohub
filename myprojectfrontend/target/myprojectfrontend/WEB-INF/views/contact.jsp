
<title>Page Title</title>
<div style="margin-bottom: -15pt">
<jsp:include page="navbar.jsp"></jsp:include>
</div>
<style>
@import 'https://fonts.googleapis.com/css?family=Libre+Franklin:400,700';
html,
body {
  background: #D9B280;
  font-family: "Libre Franklin", sans-serif;
}

.container {
  background: #FFFFFF;
  width: 900px;
  height: 650px;
  margin: 5% auto;
  position: relative;
}
.container .map {
  width: 45%;
  float: left;
}
.container .contact-form {
  width: 50%;
  margin-left: 2%;
  float: left;
}
.container .contact-form .title {
  font-size: 2.5em;
  font-family: "Libre Franklin", sans-serif;
  font-weight: 700;
  color: #242424;
  margin: 5% 8%;
}
.container .contact-form .subtitle {
  font-size: 1.2em;
  font-weight: 400;
  margin: 0 4% 5% 8%;
}
.container .contact-form input,
.container .contact-form textarea {
  width: 330px;
  padding: 3%;
  margin: 2% 8%;
  color: #242424;
  border: 1px solid #B7B7B7;
}
.container .contact-form input::placeholder,
.container .contact-form textarea::placeholder {
  color: #242424;
}
.container .contact-form .btn-send {
  background: #A383C9;
  width: 180px;
  height: 60px;
  color: #FFFFFF;
  font-weight: 700;
  margin: 2% 8%;
  border: none;
}
</style>

<div class="container">
	<div class="map" style="margin-top:30px;margin-left:10px">
		<iframe width="100%" height="600" src="https://www.mapsdirections.info/en/custom-google-maps/map.php?width=100%&height=600&hl=ru&q=8th%20street%20gandhipuram%20coimbatore+(NIIT)&ie=UTF8&t=&z=16&iwloc=A&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"><a href="https://www.mapsdirections.info/en/custom-google-maps/"></iframe>
	</div>
	<div class="contact-form">
		<h1 class="title">Contact Us</h1>
		<h2 class="subtitle">We are here assist you.</h2>
		<form action="">
			<input type="text" name="name" placeholder="Your Name" />
			<input type="email" name="e-mail" placeholder="Your E-mail Adress" />
			<input type="tel" name="phone" placeholder="Your Phone Number"/>
			<textarea name="text" id="" rows="8" placeholder="Your Message"></textarea>
			<button class="btn-send">Get a Call Back</button>
		</form>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>