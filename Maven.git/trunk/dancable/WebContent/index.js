
/*
----------------------------------------------------------------------------------------------------
Accessible News Slider
----------------------------------------------------------------------------------------------------
Author:
Brian Reindel, modified and adapted by Andrea Ferracani

Author URL:
http://blog.reindel.com, http://www.micc.unifi.it/ferracani

License:
Unrestricted. This script is free for both personal and commercial use.
*/

jQuery.fn.accessNews = function( settings ) {
settings = jQuery.extend({
headline : "Top Stories",
speed : "normal",
slideBy : 2
}, settings);
return this.each(function() {
jQuery.fn.accessNews.run( jQuery( this ), settings );
});
};

jQuery.fn.accessNews.run = function( $this, settings ) {
jQuery( ".javascript_css", $this ).css( "display", "none" );
var ul = jQuery( "ul:eq(0)", $this );
var li = ul.children();
var current = 1;
if ( li.length > settings.slideBy ) {
var $next = jQuery( ".next > a", $this );
var $back = jQuery( ".back > a", $this );
var liWidth = jQuery( li[0] ).width();
var animating = false;
ul.css( "width", ( li.length * liWidth ) );
$next.click(function() {
if ( !animating ) {
animating = true;
offsetLeft = parseInt( ul.css( "left" ) ) - ( liWidth * settings.slideBy );
if ( offsetLeft + ul.width() > 0 ) {
current++;
jQuery('.count').html( settings.headline + " " + (((current * settings.slideBy) - settings.slideBy) + 1) + " - "+ current * settings.slideBy + " of " + li.length);
$back.show();
ul.animate({
left: offsetLeft
}, settings.speed, function() {
if ( parseInt( ul.css( "left" ) ) + ul.width() <= liWidth * settings.slideBy ) {
}
animating = false;
});
} else {
animating = false;
}
}
return false;
});
$back.click(function() {
if ( !animating ) {
animating = true;
offsetRight = parseInt( ul.css( "left" ) ) + ( liWidth * settings.slideBy );
if ( offsetRight + ul.width() <= ul.width() ) {
current--;
if(current !== 1) {
jQuery('.count').html( settings.headline + " " + ((current * settings.slideBy) - settings.slideBy) + " - " + current * settings.slideBy + " of " + li.length);
} else {
jQuery('.count').html( settings.headline + " " + (((current * settings.slideBy) - settings.slideBy) + 1) + " - "+ current * settings.slideBy + " of "+ li.length);
}
$next.show();
ul.animate({
left: offsetRight
}, settings.speed, function() {
if ( parseInt( ul.css( "left" ) ) == 0 ) {

}
animating = false;
});
} else {
animating = false;
}
}
return false;
});

$next.show();
jQuery(".description").hide();
jQuery('#list').after( [ "<div class=\"view_all\"><span class=\"count\">", " total</span></div>" ].join( "" ) );
if(current !== 1) {
jQuery('.count').html( settings.headline + " " + (((current * settings.slideBy) - settings.slideBy) + 1) + " - " + current * settings.slideBy + " of " + li.length);
} else {
jQuery('.count').html( settings.headline + " " + (((current * settings.slideBy) - settings.slideBy) + 1) + " - "+ current * settings.slideBy + " of "+ li.length);
}
jQuery( ".back").appendTo('.view_all');
jQuery( ".next").appendTo('.view_all');
var date = jQuery('<div></div>');
var firstimg = jQuery( "ul li:eq(0) img", $this );
//date.appendTo("#container").html("<p class='date'><strong>TODAY NEWS</strong>: 2010 June 24</p>");
img = jQuery('<img></img>')
img.appendTo("#container");
img.attr('src', firstimg.attr('src'));
para = jQuery('<div></div>');
para.appendTo("#container");
var firstli = jQuery( "#newsslider ul li:eq(0)");
para.html("<Font face=arial size=2><b>" +  jQuery('a.title', firstli ).text() + "</b></font>" + "<p id='paraText'>" + jQuery('p.description', firstli).html() + "</p>");
firstli.addClass('selected');
li.hover(
function () {
li.removeClass('selected')
var current = jQuery(this);
current.addClass('selected');
img.attr('src', current.find('img').attr('src'));
para.html("<font face=arial size=2><b>" +  jQuery('.title', current).text() + "</b></font>" + "<p id='paraText'>" + jQuery('.description', current).html() + "</p>");
},
function () {
current.parent().css('backgroundColor', 'transparent');
}
);
}
};
