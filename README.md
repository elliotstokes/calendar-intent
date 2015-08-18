calendar-intent
===============

Opens up an intent to create a calendar event

installation

To install run the following command

    $ cordova plugins add https://github.com/elliotstokes/calendar-intent


To use

```javascript

cordova.plugins.calendarIntent.createEvent({
        title: 'Event title',
        description: 'Event Description',
        location: "somewhere"
        beginTime: '1547251200000',
        endTime: '1578787200000'
    },
    function(args) {console.log('success', args);},
    function(args) {console.log('fail', args);});

```

