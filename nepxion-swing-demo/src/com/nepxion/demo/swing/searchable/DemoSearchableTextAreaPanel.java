package com.nepxion.demo.swing.searchable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.awt.*;
import javax.swing.*;

import com.nepxion.swing.layout.table.*;
import com.nepxion.swing.searchable.*;
import com.nepxion.swing.statusbar.*;

public class DemoSearchableTextAreaPanel
    extends JPanel
{
    public DemoSearchableTextAreaPanel()
    {
        double[][] size =
            {
            {TableLayout.FILL},
            {0.5, 0.5}
        };
        TableLayout tableLayout = new TableLayout(size);
        JPanel panel = new JPanel();
        panel.setLayout(tableLayout);
        panel.add(createTextArea(), "0, 0");
        panel.add(createTextAreaContainer(), "0, 1");

        JStatusBar statusBar = new JStatusBar();
        statusBar.addItem(new JStatusItem(new JLabel(" °´CTRL+Fºô³ö²éÑ¯¿ò")), 400);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
    }

    private JScrollPane createTextArea()
    {
        JTextArea textArea = new JTextArea();
        textArea.setRows(15);
        String[] countryNames = getCountryNames();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < countryNames.length; i++) {
            String name = countryNames[i];
            buf.append(name);
            buf.append("\n");
        }
        textArea.setText(buf.toString());

        JSearchableFactory.installSearchable(textArea);
        return new JScrollPane(textArea);
    }

    private JSearchableContainer createTextAreaContainer()
    {
        JTextArea textArea = new JTextArea();
        textArea.setRows(15);
        String[] countryNames = getCountryNames();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < countryNames.length; i++) {
            String name = countryNames[i];
            buf.append(name);
            buf.append("\n");
        }
        textArea.setText(buf.toString());

        JSearchableContainer container = new JSearchableContainer();
        container.add(new JScrollPane(textArea));

        JSearchableFactory.installSearchableBar(textArea, container);
        return container;
    }

    public static String[] getCountryNames() {
        return new String[]{
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
