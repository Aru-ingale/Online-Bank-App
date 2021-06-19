var cities = new Array();
cities['Andhra Pradesh'] = new Array('Visakhapatnam', 'Vijayawada', 'Kurnool', 'Kakinada', 'Guntur', 'Nellore', 'Tirupati');
cities['Bihar'] = new Array('Gaya', 'Biharsharif', 'Darbhanga', 'Bhagalpur');
cities['Chhattisgarh'] = new Array('Bilaspur', 'Korba', 'Durg-Bhilainagar', 'Raigarh', 'Rajnandgaon');
cities['Goa'] = new Array('Vasco-da-Gama', 'Ponda', 'Margao', 'Mapusa', 'Goa_Velha');
cities['Gujarat'] = new Array('Ahmedabad', 'Surat', 'Rajkot', 'Junagadh', 'Vadodara');
cities['Haryana'] = new Array('Faridabad', 'Gurgaon', 'Sonipat', 'Panipat', 'Ambala');
cities['Himachal Pradesh'] = new Array('Dharamshala', 'Mandi', 'Solan', 'Bilaspur', 'Chamba');
cities['Jharkhand'] = new Array('Bokaro_Steel_City', 'Jamshedpur', 'Deoghar', 'Hazaribagh', 'Dhanbad');
cities['Karnataka'] = new Array('Mysore', 'Davangere', 'Mangalore', 'Hubli-Dharwad', 'Belgaum');
cities['Kerala'] = new Array('Kochi', 'Kozhikode', 'Thrissur', 'Malappuram');
cities['Madhya Pradesh'] = new Array('Indore', 'Gwalior', 'Jabalpur', 'Ujjain', 'Sagar');
cities['Maharashtra'] = new Array('Pune', 'Nagpur', 'Nashik', 'Aurangabad', 'Solapur');
cities['Manipur'] = new Array('Bishnupur', 'Ukhrul', 'Tamenglong', 'Chandel', 'Senapati');
cities['Meghalaya'] = new Array('Cherrapunji', 'Tura', 'Jowai', 'Baghmara', 'Nongpoh');
cities['Mizoram'] = new Array('Lunglei', 'Serchhip', 'Champhai', 'Tuipang', 'Mamit');
cities['Nagaland'] = new Array('Tuensang', 'Zunheboto', 'Mokokchung', 'Kiphire_Sadar', 'Phek');
cities['Odisha'] = new Array('Rourkela', 'Cuttack', 'Brahmapur', 'Puri', 'Sambalpur');
cities['Punjab'] = new Array('Amritsar', 'Jalandhar', 'Ludhiana', 'Patiala', 'Kapurthala');
cities['Rajasthan'] = new Array('Bikaner', 'Jaisalmer', 'Jodhpur', 'Udaipur', 'Ajmer');
cities['Sikkim'] = new Array('Namchi', 'Gyalshing', 'Mangan', 'Rabdentse');
cities['Tamil Nadu'] = new Array('Tiruchirappalli', 'Madurai', 'Erode', 'Vellore', 'Coimbatore');
cities['Telangana'] = new Array('Tiruchirappalli', 'Madurai', 'Erode', 'Vellore', 'Coimbatore');
cities['Tripura'] = new Array('Amarpur', 'Kumarghat', 'Udaipur', 'Gakulnagar', 'Kunjaban');
cities['Uttar Pradesh'] = new Array('Noida', 'Varanasi', 'Allahabad', 'Agra', 'Kanpur');
cities['Uttarakhand'] = new Array('Haridwar', 'Roorkee', 'Rishikesh', 'Kashipur', 'Haldwani');
cities['West Bengal'] = new Array('Darjeeling', 'Siliguri', 'Asansol', 'Howrah', 'Durgapur_Haldwani');
cities['Assam'] = new Array('Guwahati', 'Tezpur', 'Dibrugarh', 'Silchar', 'North_Lakhimpur');
function setCities() {
alert("In setcities");
	statesel = document.getElementById('states')
	cityList = cities[statesel.value];
	changeSelect('city', cityList, cityList);
}
function changeSelect(fieldID, newOptions, newValues) {
alert("In changeSelect"+ fieldID);
	selectField = document.getElementById(fieldID);
	selectField.options.length = 0;
	for (i = 0; i < newOptions.length; i++) {
		selectField.options[selectField.length] = new Option(newOptions[i], newValues[i]);
	}
}
function addLoadEvent(func) {
	var oldonload = window.onload;
	if (typeof window.onload != 'function') {
		window.onload = func();
	}
	else {
		window.onload = function() {
			if (oldonload) {
				oldonload();
			}
			func();
		}
	}
}
addLoadEvent(function() {
alert("Hello");
	setCities();
});