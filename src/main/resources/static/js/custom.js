
    $(document).ready(function() {
        const url = window.location.pathname;  // Get the full path of the current URL
        const complainId = url.substring(url.lastIndexOf('/') + 1);  // Extract the  ID from the URL

        // Fetch the data from the REST API
        $.ajax({
            url: '/api/complains/' + complainId,  // Fetch employee by ID from REST API
            method: 'GET',
            dataType: 'json',
            success: function(complain) {
                $('#subject').val(complain.subject);
                $('#details').val(complain.details);
                $('#cname').val(complain.name);
                $('#phone').val(complain.phone);

            },
            error: function(xhr, status, error) {
                alert('Error fetching complain: ' + error);
            }
        });


        // Attach a click event to the "Update" button
        $('#updateComplainBtn').click(function() {
            // Prepare the data to be sent in the AJAX request
            const complainData = {
                id: complainId,
                subject: $('#subject').val(),
                details: $('#details').val(),
                name: $('#cname').val(),
                phone: $('#phone').val(),
            };

            // Send the AJAX request to update the employee data
            $.ajax({
                url: '/api/complains/update/' +complainId,  // REST API endpoint for updating the employee
                type: 'PUT',  // Use PUT method for updating the employee
                contentType: 'application/json',
                data: JSON.stringify(complainData),  // Convert the data to JSON format
                success: function(response) {
                    alert('Complain updated successfully!');
                    window.location.href = "/complains";  // Redirect to employee list after success
                },
                error: function(xhr, status, error) {
                    alert('Error updating complain: ' + error);
                }
            });
        });
    });

