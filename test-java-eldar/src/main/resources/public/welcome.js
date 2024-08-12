$(function() {
	console.log("Hello world - findIp!");
	document.getElementById("FormOutput").style.display = "none";
	
	// display text in the output area
	function showOutput(text) {
	    $("#output").text(text);
	}
  
	function findIp() {
	    var ipToFind = $("#ip").val();

		console.log("ipToFind: "+ipToFind);
		
	    if (ipToFind) {
	      getIpInformation(ipToFind);
	    }
	  }
	  
	function getIpInformation( ipToFind ) {
		document.getElementById("FormOutput").style.display = "none";
		var fullUrl = "/Geolocalizacion/byIP/" + ipToFind ;
	    $.get({
	      headers: {
	          'Content-Type': 'application/json'
	      },
	      url: fullUrl
	    })
	    .done(function( data ) {
	      showOutput( "searching -- reloading");
	      console.log("data:_ " + data);
	      $("#ipResult").text(data.ip);	      
	      $("#actualDate").text(data.actualDate);
	      $("#country").text(data.country);
	      $("#isoCode").text(data.isoCode);
	      $("#language").text(data.language);
	      $("#currency").text(data.currency);
	      $("#hour").text(data.hour);
	      $("#distance").text(data.distance);
	      showOutput( JSON.stringify(data, null, 2));
	      document.getElementById("FormOutput").style.display = "block";
	    })
	    .fail(function( jqXHR, textStatus ) {
	      showOutput( "Failed: " + textStatus );
	    });
	 }
	
	$("#find_ip").on("click", findIp);
});