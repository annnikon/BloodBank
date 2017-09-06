<script>     
    
    var map;
    var marker;  
    
    function initMap() {
        var chicago = new google.maps.LatLng(49.9, 36.9);
        var map = new google.maps.Map(document.getElementById('mapRegister'), {
          center: chicago,
          zoom: 9
        });
        
        marker = new google.maps.Marker({
         	    map: map,
         	    draggable: true,
         	    animation: google.maps.Animation.DROP,
         	    position: chicago
         	  });
         	  
    
    
    google.maps.event.addListener(marker, "click", function (event) {
          
        document.getElementById('x').value=event.latLng.lat();      
        document.getElementById('y').value=event.latLng.lng();
      
      });
    marker.addListener('click', toggleBounce);
    }
    
    function toggleBounce() {
        if (marker.getAnimation() !== null) {
          marker.setAnimation(null);
        } else {
         
          
          marker.setAnimation(google.maps.Animation.BOUNCE);
        }
      }
     
      function project(latLng) {
        var siny = Math.sin(latLng.lat() * Math.PI / 180);

        // Truncating to 0.9999 effectively limits latitude to 89.189. This is
        // about a third of a tile past the edge of the world tile.
        siny = Math.min(Math.max(siny, -0.9999), 0.9999);
        var TILE_SIZE = 256;
        return new google.maps.Point(
                TILE_SIZE * (0.5 + latLng.lng() / 360), TILE_SIZE * (0.5 - Math.log((1 + siny) / (1 - siny)) / (4 * Math.PI)));
      }
    
    
 
</script>
   

    
      
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCqdjZ5cYzvvUOBzx9lqPjiksR0ZTC_DBM&callback=initMap">
    </script>