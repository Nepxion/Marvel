package com.nepxion.demo.component.searchable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.Position;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.searchable.JSearchableContainer;
import com.nepxion.swing.searchable.JSearchableFactory;

public class DemoSearchableListPanel
	extends JPanel
{
	public DemoSearchableListPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new SearchableListPanel());
	}
	
	public class SearchableListPanel
		extends JPanel
	{
		public SearchableListPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Searchable List"));
			
			add(createList());
			add(createListContainer());	
		}
	}
	
	 private JScrollPane createList()
	{
		JList list = new JList(getCountryNames())
		{
			public int getNextMatch(String prefix, int startIndex, Position.Bias bias)
			{
				return -1;
			}
		};
		list.setVisibleRowCount(15);
		
		JSearchableFactory.installSearchable(list);
		return new JScrollPane(list);
	}
	
	private JSearchableContainer createListContainer()
	{
		JList list = new JList(getCountryNames())
		{
			public int getNextMatch(String prefix, int startIndex, Position.Bias bias)
			{
				return -1;
			}
		};
		list.setVisibleRowCount(15);
		
		JSearchableContainer container = new JSearchableContainer();
		container.add(new JScrollPane(list));
		
		JSearchableFactory.installSearchableBar(list, container);
		return container;
	}

    public static String[] getCountryNames()
    {
        return new String[]
            {
            "Andorra",
            "United Arab Emirates",
            "Afghanistan",
            "Antigua And Barbuda",
            "Anguilla",
            "Albania",
            "Armenia",
            "Netherlands Antilles",
            "Angola",
            "Antarctica",
            "Argentina",
            "American Samoa",
            "Austria",
            "Australia",
            "Aruba",
            "Azerbaijan",
            "Bosnia And Herzegovina",
            "Barbados",
            "Bangladesh",
            "Belgium",
            "Burkina Faso",
            "Bulgaria",
            "Bahrain",
            "Burundi",
            "Benin",
            "Bermuda",
            "Brunei Darussalam",
            "Bolivia",
            "Brazil",
            "Bahamas",
            "Bhutan",
            "Bouvet Island",
            "Botswana",
            "Belarus",
            "Belize",
            "Canada",
            "Cocos (Keeling) Islands",
            "Congo, The Democratic Republic Of The",
            "Central African Republic",
            "Congo",
            "Switzerland",
            "Côte D'Ivoire",
            "Cook Islands",
            "Chile",
            "Cameroon",
            "China",
            "Colombia",
            "Costa Rica",
            "Cuba",
            "Cape Verde",
            "Christmas Island",
            "Cyprus",
            "Czech Republic",
            "Germany",
            "Djibouti",
            "Denmark",
            "Dominica",
            "Dominican Republic",
            "Algeria",
            "Ecuador",
            "Estonia",
            "Egypt",
            "Western Sarara",
            "Eritrea",
            "Spain",
            "Ethiopia",
            "Finland",
            "Fiji",
            "Falkland Islands (Malvinas)",
            "Micronesia, Federated States Of",
            "Faroe Islands",
            "France",
            "Gabon",
            "United Kingdom",
            "Grenada",
            "Georgia",
            "French Guiana",
            "Ghana",
            "Gibraltar",
            "Greenland",
            "Gambia",
            "Guinea",
            "Guadeloupe",
            "Equatorial Guinea",
            "Greece",
            "South Georgia And The South Sandwich Islands",
            "Guatemala",
            "Guam",
            "Guinea-bissau",
            "Guyana",
            "Hong Kong",
            "Heard Island And Mcdonald Islands",
            "Honduras",
            "Croatia",
            "Haiti",
            "Hungary",
            "Indonesia",
            "Ireland",
            "Israel",
            "India",
            "British Indian Ocean Territory",
            "Iraq",
            "Iran, Islamic Republic Of",
            "Iceland",
            "Italy",
            "Jamaica",
            "Jordan",
            "Japan",
            "Kenya",
            "Kyrgyzstan",
            "Cambodia",
            "Kiribati",
            "Comoros",
            "Saint Kitts And Nevis",
            "Korea, Democratic People'S Republic Of",
            "Korea, Republic Of",
            "Kuwait",
            "Cayman Islands",
            "Kazakhstan",
            "Lao People'S Democratic Republic",
            "Lebanon",
            "Saint Lucia",
            "Liechtenstein",
            "Sri Lanka",
            "Liberia",
            "Lesotho",
            "Lithuania",
            "Luxembourg",
            "Latvia",
            "Libyan Arab Jamabiriya",
            "Morocco",
            "Monaco",
            "Moldova, Republic Of",
            "Madagascar",
            "Marshall Islands",
            "Macedonia, The Former Yugoslav Repu8lic Of",
            "Mali",
            "Myanmar",
            "Mongolia",
            "Macau",
            "Northern Mariana Islands",
            "Martinique",
            "Mauritania",
            "Montserrat",
            "Malta",
            "Mauritius",
            "Maldives",
            "Malawi",
            "Mexico",
            "Malaysia",
            "Mozambique",
            "Namibia",
            "New Caledonia",
            "Niger",
            "Norfolk Island",
            "Nigeria",
            "Nicaragua",
            "Netherlands",
            "Norway",
            "Nepal",
            "Niue",
            "New Zealand",
            "Oman",
            "Panama",
            "Peru",
            "French Polynesia",
            "Papua New Guinea",
            "Philippines",
            "Pakistan",
            "Poland",
            "Saint Pierre And Miquelon",
            "Pitcairn",
            "Puerto Rico",
            "Portugal",
            "Palau",
            "Paraguay",
            "Qatar",
            "Réunion",
            "Romania",
            "Russian Federation",
            "Rwanda",
            "Saudi Arabia",
            "Solomon Islands",
            "Seychelles",
            "Sudan",
            "Sweden",
            "Singapore",
            "Saint Helena",
            "Slovenia",
            "Svalbard And Jan Mayen",
            "Slovakia",
            "Sierra Leone",
            "San Marino",
            "Senegal",
            "Somalia",
            "Suriname",
            "Sao Tome And Principe",
            "El Salvador",
            "Syrian Arab Republic",
            "Swaziland",
            "Turks And Caicos Islands",
            "Chad",
            "French Southern Territories",
            "Togo",
            "Thailand",
            "Tajikistan",
            "Tokelau",
            "Turkmenistan",
            "Tunisia",
            "Tonga",
            "East Timor",
            "Turkey",
            "Trinidad And Tobago",
            "Tuvalu",
            "Taiwan, Province Of China",
            "Tanzania, United Republic Of",
            "Ukraine",
            "Uganda",
            "United States Minor Outlying Islands",
            "United States",
            "Uruguay",
            "Uzbekistan",
            "Venezuela",
            "Virgin Islands, British",
            "Virgin Islands, U.S.",
            "Viet Nam",
            "Vanuatu",
            "Wallis And Futuna",
            "Samoa",
            "Yemen",
            "Mayotte",
            "Yugoslavia",
            "South Africa",
            "Zambia",
            "Zimbabwe"
        };
    }
}