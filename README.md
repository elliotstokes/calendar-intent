calendar-intent
===============

Intents for Cordova integration with android calendar

Will open a calendar up on a specific day or will open up the create event for a calendar.


installation

To install run the following command

    $ cordova plugins add https://github.com/elliotstokes/calendar-intent



Creating Events
================

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


Opening up the Calendar
========================

To use
```javascript
	cordova.plugins.calendarIntent.openCalendar({
		time: '1578787200000'
	})
    function(args) {console.log('success', args);},
    function(args) {console.log('fail', args);});;
```
