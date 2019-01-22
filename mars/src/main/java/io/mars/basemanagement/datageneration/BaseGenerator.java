package io.mars.basemanagement.datageneration;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.mars.basemanagement.BasemanagementPAO;
import io.mars.basemanagement.dao.BaseDAO;
import io.mars.basemanagement.dao.PictureDAO;
import io.mars.basemanagement.domain.Base;
import io.mars.basemanagement.domain.Picture;
import io.mars.fileinfo.FileInfoStd;
import io.vertigo.commons.transaction.Transactional;
import io.vertigo.core.component.Component;
import io.vertigo.dynamo.file.FileManager;
import io.vertigo.dynamo.file.model.FileInfo;
import io.vertigo.dynamo.file.model.VFile;
import io.vertigo.dynamo.store.StoreManager;

@Transactional
public class BaseGenerator implements Component {

	@Inject
	private BasemanagementPAO basemanagementPAO;

	@Inject
	private BaseDAO baseDAO;
	@Inject
	private PictureDAO pictureDAO;

	@Inject
	private FileManager fileManager;
	@Inject
	private StoreManager storeManager;

	public List<Base> generateInitialBases() {
		final List<String> geoLocations = Arrays.asList(" { \"lon\": 9.55 , \"lat\" : 44.050000 } ", " { \"lon\": -54.283333 , \"lat\" : -36.500000 } ",
				" { \"lon\": -49.35 , \"lat\" : 70.216667 } ", " { \"lon\": 31.766666666666666 , \"lat\" : 35.233333 } ", " { \"lon\": 60.116667 , \"lat\" : 19.900000 } ", " { \"lon\": -0.5477 , \"lat\" : 166.920867 } ", " { \"lon\": 18.0731 , \"lat\" : -63.082200 } ", " { \"lon\": -9.166667 , \"lat\" : -171.833333 } ",
				" { \"lon\": 27.153611 , \"lat\" : -13.203333 } ", " { \"lon\": 34.516666666666666 , \"lat\" : 69.183333 } ", " { \"lon\": 41.31666666666667 , \"lat\" : 19.816667 } ", " { \"lon\": 36.75 , \"lat\" : 3.050000 } ",
				" { \"lon\": -14.266666666666667 , \"lat\" : -170.700000 } ", " { \"lon\": 42.5 , \"lat\" : 1.516667 } ", " { \"lon\": -8.833333333333334 , \"lat\" : 13.216667 } ", " { \"lon\": 18.216666666666665 , \"lat\" : -63.050000 } ",
				" { \"lon\": 17.116666666666667 , \"lat\" : -61.850000 } ", " { \"lon\": -34.583333333333336 , \"lat\" : -58.666667 } ", " { \"lon\": 40.166666666666664 , \"lat\" : 44.500000 } ", " { \"lon\": 12.516666666666667 , \"lat\" : -70.033333 } ",
				" { \"lon\": -35.266666666666666 , \"lat\" : 149.133333 } ", " { \"lon\": 48.2 , \"lat\" : 16.366667 } ", " { \"lon\": 40.38333333333333 , \"lat\" : 49.866667 } ", " { \"lon\": 25.083333333333332 , \"lat\" : -77.350000 } ",
				" { \"lon\": 26.233333333333334 , \"lat\" : 50.566667 } ", " { \"lon\": 23.716666666666665 , \"lat\" : 90.400000 } ", " { \"lon\": 13.1 , \"lat\" : -59.616667 } ", " { \"lon\": 53.9 , \"lat\" : 27.566667 } ",
				" { \"lon\": 50.833333333333336 , \"lat\" : 4.333333 } ", " { \"lon\": 17.25 , \"lat\" : -88.766667 } ", " { \"lon\": 6.483333333333333 , \"lat\" : 2.616667 } ", " { \"lon\": 32.28333333333333 , \"lat\" : -64.783333 } ",
				" { \"lon\": 27.466666666666665 , \"lat\" : 89.633333 } ", " { \"lon\": -16.5 , \"lat\" : -68.150000 } ", " { \"lon\": 43.86666666666667 , \"lat\" : 18.416667 } ", " { \"lon\": -24.633333333333333 , \"lat\" : 25.900000 } ",
				" { \"lon\": -15.783333333333333 , \"lat\" : -47.916667 } ", " { \"lon\": 18.416666666666668 , \"lat\" : -64.616667 } ", " { \"lon\": 4.883333333333333 , \"lat\" : 114.933333 } ", " { \"lon\": 42.68333333333333 , \"lat\" : 23.316667 } ",
				" { \"lon\": 12.366666666666667 , \"lat\" : -1.516667 } ", " { \"lon\": 16.8 , \"lat\" : 96.150000 } ", " { \"lon\": -3.3666666666666667 , \"lat\" : 29.350000 } ", " { \"lon\": 11.55 , \"lat\" : 104.916667 } ",
				" { \"lon\": 3.8666666666666667 , \"lat\" : 11.516667 } ", " { \"lon\": 45.416666666666664 , \"lat\" : -75.700000 } ", " { \"lon\": 14.916666666666666 , \"lat\" : -23.516667 } ", " { \"lon\": 19.3 , \"lat\" : -81.383333 } ",
				" { \"lon\": 4.366666666666666 , \"lat\" : 18.583333 } ", " { \"lon\": 12.1 , \"lat\" : 15.033333 } ", " { \"lon\": -33.45 , \"lat\" : -70.666667 } ", " { \"lon\": 39.916666666666664 , \"lat\" : 116.383333 } ",
				" { \"lon\": -10.416666666666666 , \"lat\" : 105.716667 } ", " { \"lon\": -12.166666666666666 , \"lat\" : 96.833333 } ", " { \"lon\": 4.6 , \"lat\" : -74.083333 } ", " { \"lon\": -11.7 , \"lat\" : 43.233333 } ",
				" { \"lon\": -4.316666666666666 , \"lat\" : 15.300000 } ", " { \"lon\": -4.25 , \"lat\" : 15.283333 } ", " { \"lon\": -21.2 , \"lat\" : -159.766667 } ", " { \"lon\": 9.933333333333334 , \"lat\" : -84.083333 } ",
				" { \"lon\": 6.816666666666666 , \"lat\" : -5.266667 } ", " { \"lon\": 45.8 , \"lat\" : 16.000000 } ", " { \"lon\": 23.116666666666667 , \"lat\" : -82.350000 } ", " { \"lon\": 12.1 , \"lat\" : -68.916667 } ",
				" { \"lon\": 35.166666666666664 , \"lat\" : 33.366667 } ", " { \"lon\": 50.083333333333336 , \"lat\" : 14.466667 } ", " { \"lon\": 55.666666666666664 , \"lat\" : 12.583333 } ", " { \"lon\": 11.583333333333334 , \"lat\" : 43.150000 } ",
				" { \"lon\": 15.3 , \"lat\" : -61.400000 } ", " { \"lon\": 18.466666666666665 , \"lat\" : -69.900000 } ", " { \"lon\": -0.21666666666666667 , \"lat\" : -78.500000 } ", " { \"lon\": 30.05 , \"lat\" : 31.250000 } ",
				" { \"lon\": 13.7 , \"lat\" : -89.200000 } ", " { \"lon\": 3.75 , \"lat\" : 8.783333 } ", " { \"lon\": 15.333333333333334 , \"lat\" : 38.933333 } ", " { \"lon\": 59.43333333333333 , \"lat\" : 24.716667 } ",
				" { \"lon\": 9.033333333333333 , \"lat\" : 38.700000 } ", " { \"lon\": -51.7 , \"lat\" : -57.850000 } ", " { \"lon\": 62 , \"lat\" : -6.766667 } ", " { \"lon\": -18.133333333333333 , \"lat\" : 178.416667 } ",
				" { \"lon\": 60.166666666666664 , \"lat\" : 24.933333 } ", " { \"lon\": 48.86666666666667 , \"lat\" : 2.333333 } ", " { \"lon\": -17.533333333333335 , \"lat\" : -149.566667 } ", " { \"lon\": 0.38333333333333336 , \"lat\" : 9.450000 } ", " { \"lon\": 13.45 , \"lat\" : -16.566667 } ",
				" { \"lon\": 41.68333333333333 , \"lat\" : 44.833333 } ", " { \"lon\": 52.516666666666666 , \"lat\" : 13.400000 } ", " { \"lon\": 5.55 , \"lat\" : -0.216667 } ", " { \"lon\": 36.13333333333333 , \"lat\" : -5.350000 } ",
				" { \"lon\": 37.983333333333334 , \"lat\" : 23.733333 } ", " { \"lon\": 64.18333333333334 , \"lat\" : -51.750000 } ", " { \"lon\": 12.05 , \"lat\" : -61.750000 } ", " { \"lon\": 13.466666666666667 , \"lat\" : 144.733333 } ",
				" { \"lon\": 14.616666666666667 , \"lat\" : -90.516667 } ", " { \"lon\": 49.45 , \"lat\" : -2.533333 } ", " { \"lon\": 9.5 , \"lat\" : -13.700000 } ", " { \"lon\": 11.85 , \"lat\" : -15.583333 } ",
				" { \"lon\": 6.8 , \"lat\" : -58.150000 } ", " { \"lon\": 18.533333333333335 , \"lat\" : -72.333333 } ", " { \"lon\": 41.9 , \"lat\" : 12.450000 } ", " { \"lon\": 14.1 , \"lat\" : -87.216667 } ",
				" { \"lon\": 47.5 , \"lat\" : 19.083333 } ", " { \"lon\": 64.15 , \"lat\" : -21.950000 } ", " { \"lon\": 28.6 , \"lat\" : 77.200000 } ", " { \"lon\": -6.166666666666667 , \"lat\" : 106.816667 } ",
				" { \"lon\": 35.7 , \"lat\" : 51.416667 } ", " { \"lon\": 33.333333333333336 , \"lat\" : 44.400000 } ", " { \"lon\": 53.31666666666667 , \"lat\" : -6.233333 } ", " { \"lon\": 54.15 , \"lat\" : -4.483333 } ",
				" { \"lon\": 31.766666666666666 , \"lat\" : 35.233333 } ", " { \"lon\": 41.9 , \"lat\" : 12.483333 } ", " { \"lon\": 18 , \"lat\" : -76.800000 } ", " { \"lon\": 35.68333333333333 , \"lat\" : 139.750000 } ",
				" { \"lon\": 49.18333333333333 , \"lat\" : -2.100000 } ", " { \"lon\": 31.95 , \"lat\" : 35.933333 } ", " { \"lon\": 51.166666666666664 , \"lat\" : 71.416667 } ", " { \"lon\": -1.2833333333333332 , \"lat\" : 36.816667 } ",
				" { \"lon\": -0.8833333333333333 , \"lat\" : 169.533333 } ", " { \"lon\": 39.016666666666666 , \"lat\" : 125.750000 } ", " { \"lon\": 37.55 , \"lat\" : 126.983333 } ", " { \"lon\": 42.666666666666664 , \"lat\" : 21.166667 } ",
				" { \"lon\": 29.366666666666667 , \"lat\" : 47.966667 } ", " { \"lon\": 42.86666666666667 , \"lat\" : 74.600000 } ", " { \"lon\": 17.966666666666665 , \"lat\" : 102.600000 } ", " { \"lon\": 56.95 , \"lat\" : 24.100000 } ",
				" { \"lon\": 33.86666666666667 , \"lat\" : 35.500000 } ", " { \"lon\": -29.316666666666666 , \"lat\" : 27.483333 } ", " { \"lon\": 6.3 , \"lat\" : -10.800000 } ", " { \"lon\": 32.88333333333333 , \"lat\" : 13.166667 } ",
				" { \"lon\": 47.13333333333333 , \"lat\" : 9.516667 } ", " { \"lon\": 54.68333333333333 , \"lat\" : 25.316667 } ", " { \"lon\": 49.6 , \"lat\" : 6.116667 } ", " { \"lon\": 42 , \"lat\" : 21.433333 } ",
				" { \"lon\": -18.916666666666668 , \"lat\" : 47.516667 } ", " { \"lon\": -13.966666666666667 , \"lat\" : 33.783333 } ", " { \"lon\": 3.1666666666666665 , \"lat\" : 101.700000 } ", " { \"lon\": 4.166666666666667 , \"lat\" : 73.500000 } ",
				" { \"lon\": 12.65 , \"lat\" : -8.000000 } ", " { \"lon\": 35.88333333333333 , \"lat\" : 14.500000 } ", " { \"lon\": 7.1 , \"lat\" : 171.383333 } ", " { \"lon\": 18.066666666666666 , \"lat\" : -15.966667 } ",
				" { \"lon\": -20.15 , \"lat\" : 57.483333 } ", " { \"lon\": 19.433333333333334 , \"lat\" : -99.133333 } ", " { \"lon\": 6.916666666666667 , \"lat\" : 158.150000 } ", " { \"lon\": 47 , \"lat\" : 28.850000 } ",
				" { \"lon\": 43.733333333333334 , \"lat\" : 7.416667 } ", " { \"lon\": 47.916666666666664 , \"lat\" : 106.916667 } ", " { \"lon\": 42.43333333333333 , \"lat\" : 19.266667 } ", " { \"lon\": 16.7 , \"lat\" : -62.216667 } ",
				" { \"lon\": 34.016666666666666 , \"lat\" : -6.816667 } ", " { \"lon\": -25.95 , \"lat\" : 32.583333 } ", " { \"lon\": -22.566666666666666 , \"lat\" : 17.083333 } ", " { \"lon\": 27.716666666666665 , \"lat\" : 85.316667 } ",
				" { \"lon\": 52.35 , \"lat\" : 4.916667 } ", " { \"lon\": -22.266666666666666 , \"lat\" : 166.450000 } ", " { \"lon\": -41.3 , \"lat\" : 174.783333 } ", " { \"lon\": 12.133333333333333 , \"lat\" : -86.250000 } ",
				" { \"lon\": 13.516666666666667 , \"lat\" : 2.116667 } ", " { \"lon\": 9.083333333333334 , \"lat\" : 7.533333 } ", " { \"lon\": -19.016666666666666 , \"lat\" : -169.916667 } ", " { \"lon\": -29.05 , \"lat\" : 167.966667 } ",
				" { \"lon\": 15.2 , \"lat\" : 145.750000 } ", " { \"lon\": 59.916666666666664 , \"lat\" : 10.750000 } ", " { \"lon\": 23.616666666666667 , \"lat\" : 58.583333 } ", " { \"lon\": 33.68333333333333 , \"lat\" : 73.050000 } ",
				" { \"lon\": 7.483333333333333 , \"lat\" : 134.633333 } ", " { \"lon\": 8.966666666666667 , \"lat\" : -79.533333 } ", " { \"lon\": -9.45 , \"lat\" : 147.183333 } ", " { \"lon\": -25.266666666666666 , \"lat\" : -57.666667 } ",
				" { \"lon\": -12.05 , \"lat\" : -77.050000 } ", " { \"lon\": 14.6 , \"lat\" : 120.966667 } ", " { \"lon\": -25.066666666666666 , \"lat\" : -130.083333 } ", " { \"lon\": 52.25 , \"lat\" : 21.000000 } ",
				" { \"lon\": 38.71666666666667 , \"lat\" : -9.133333 } ", " { \"lon\": 18.466666666666665 , \"lat\" : -66.116667 } ", " { \"lon\": 25.283333333333335 , \"lat\" : 51.533333 } ", " { \"lon\": 44.43333333333333 , \"lat\" : 26.100000 } ",
				" { \"lon\": 55.75 , \"lat\" : 37.600000 } ", " { \"lon\": -1.95 , \"lat\" : 30.050000 } ", " { \"lon\": 17.883333333333333 , \"lat\" : -62.850000 } ", " { \"lon\": -15.933333333333334 , \"lat\" : -5.716667 } ",
				" { \"lon\": 17.3 , \"lat\" : -62.716667 } ", " { \"lon\": 14 , \"lat\" : -61.000000 } ", " { \"lon\": 46.766666666666666 , \"lat\" : -56.183333 } ", " { \"lon\": 13.133333333333333 , \"lat\" : -61.216667 } ",
				" { \"lon\": -13.816666666666666 , \"lat\" : -171.766667 } ", " { \"lon\": 43.93333333333333 , \"lat\" : 12.416667 } ", " { \"lon\": 0.3333333333333333 , \"lat\" : 6.733333 } ", " { \"lon\": 24.65 , \"lat\" : 46.700000 } ",
				" { \"lon\": 14.733333333333333 , \"lat\" : -17.633333 } ", " { \"lon\": 44.833333333333336 , \"lat\" : 20.500000 } ", " { \"lon\": -4.616666666666667 , \"lat\" : 55.450000 } ", " { \"lon\": 8.483333333333333 , \"lat\" : -13.233333 } ",
				" { \"lon\": 1.2833333333333332 , \"lat\" : 103.850000 } ", " { \"lon\": 18.016666666666666 , \"lat\" : -63.033333 } ", " { \"lon\": 48.15 , \"lat\" : 17.116667 } ", " { \"lon\": 46.05 , \"lat\" : 14.516667 } ",
				" { \"lon\": -9.433333333333334 , \"lat\" : 159.950000 } ", " { \"lon\": 2.066666666666667 , \"lat\" : 45.333333 } ", " { \"lon\": -25.7 , \"lat\" : 28.216667 } ", " { \"lon\": 4.85 , \"lat\" : 31.616667 } ",
				" { \"lon\": 40.4 , \"lat\" : -3.683333 } ", " { \"lon\": 6.916666666666667 , \"lat\" : 79.833333 } ", " { \"lon\": 15.6 , \"lat\" : 32.533333 } ", " { \"lon\": 5.833333333333333 , \"lat\" : -55.166667 } ",
				" { \"lon\": 78.21666666666667 , \"lat\" : 15.633333 } ", " { \"lon\": -26.316666666666666 , \"lat\" : 31.133333 } ", " { \"lon\": 59.333333333333336 , \"lat\" : 18.050000 } ", " { \"lon\": 46.916666666666664 , \"lat\" : 7.466667 } ",
				" { \"lon\": 33.5 , \"lat\" : 36.300000 } ", " { \"lon\": 25.033333333333335 , \"lat\" : 121.516667 } ", " { \"lon\": 38.55 , \"lat\" : 68.766667 } ", " { \"lon\": -6.8 , \"lat\" : 39.283333 } ",
				" { \"lon\": 13.75 , \"lat\" : 100.516667 } ", " { \"lon\": -8.583333333333334 , \"lat\" : 125.600000 } ", " { \"lon\": 6.116666666666666 , \"lat\" : 1.216667 } ", " { \"lon\": -21.133333333333333 , \"lat\" : -175.200000 } ",
				" { \"lon\": 10.65 , \"lat\" : -61.516667 } ", " { \"lon\": 36.8 , \"lat\" : 10.183333 } ", " { \"lon\": 39.93333333333333 , \"lat\" : 32.866667 } ", " { \"lon\": 37.95 , \"lat\" : 58.383333 } ",
				" { \"lon\": 21.466666666666665 , \"lat\" : -71.133333 } ", " { \"lon\": -8.516666666666667 , \"lat\" : 179.216667 } ", " { \"lon\": 0.31666666666666665 , \"lat\" : 32.550000 } ", " { \"lon\": 50.43333333333333 , \"lat\" : 30.516667 } ",
				" { \"lon\": 24.466666666666665 , \"lat\" : 54.366667 } ", " { \"lon\": 51.5 , \"lat\" : -0.083333 } ", " { \"lon\":  D.C. , \"lat\" : 38.883333 } ", " { \"lon\": -34.85 , \"lat\" : -56.166667 } ",
				" { \"lon\": 41.31666666666667 , \"lat\" : 69.250000 } ", " { \"lon\": -17.733333333333334 , \"lat\" : 168.316667 } ", " { \"lon\": 10.483333333333333 , \"lat\" : -66.866667 } ", " { \"lon\": 21.033333333333335 , \"lat\" : 105.850000 } ",
				" { \"lon\": 18.35 , \"lat\" : -64.933333 } ", " { \"lon\": -13.95 , \"lat\" : -171.933333 } ", " { \"lon\": 15.35 , \"lat\" : 44.200000 } ", " { \"lon\": -15.416666666666666 , \"lat\" : 28.283333 } ",
				" { \"lon\": -17.816666666666666 , \"lat\" : 31.033333 } ", " { \"lon\":  D.C. , \"lat\" : 38.883333 } ", " { \"lon\": 35.183333 , \"lat\" : 33.366667 } ",
				" { \"lon\": -7.3 , \"lat\" : 72.400000 } ");

		final List<String> nameFirstPartDictionnary1 = Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta");
		final List<String> nameSecondPartDictionnary2 = Arrays.asList("Aldebaran", "Centauri", "Pisces", "Cygnus", "Pegasus", "Dragon", "Andromeda");
		final List<String> sampleTags = Arrays.asList("#mountain", "#sea", "#historic", "#cold", "#first", "#nasa", "#experimental");

		final String exteriorPicturePrefix = "/initdata/files/bases/mars base ";
		final String exteriorPictureSuffix = ".jpg";
		final String interiorPicturePrefix = "/initdata/files/bases/inner base ";
		final String interiorPictureSuffix = ".jpg";

		final FakeBaseListBuilder builder = new FakeBaseListBuilder()
				.withMaxValues(10)
				.withGeosectorIds(basemanagementPAO.selectGeosectorId())
				.withGeoLocations(geoLocations)
				.withNameDictionnaries(nameSecondPartDictionnary2, nameFirstPartDictionnary1)
				.withTagsDictionnary(sampleTags)
				.withPictures(1, exteriorPicturePrefix, exteriorPictureSuffix)
				.withPictures(2, interiorPicturePrefix, interiorPictureSuffix);

		final List<Base> bases = builder.build();
		//base location
		bases.get(0).setName("Aldebaran (Paris)");
		bases.get(0).setGeoLocation("{ \"lon\": 2.333333 , \"lat\" : 48.866667 } ");
		bases.get(0).setCode("Paris-Aldebaran");
		bases.get(0).setDescription("The Aldebaran base was the first base of the MMC and managed by Paris."
				+ " The first settlers, led by James T. Kirk, planted the flag in a crater, near a frozen lake.\n"
				+ "The crater is one kilometer deep, which offers a mountain-like landscape.\n"
				+ "The place is rich in minerals, especially in antimony.");

		bases.get(1).setName("Centauri (Oslo)");
		bases.get(1).setGeoLocation("{ \"lon\": 10.752245399999993 , \"lat\" : 59.9138688 } ");
		bases.get(1).setCode("Oslo-Centauri");
		bases.get(1).setDescription("The Centauri base is managed by Oslo. "
				+ "The first settlers, led by John König, planted the flag near Utopia Planitia.\n"
				+ "The area is flat and several kilometers long.\n"
				+ "The place is ideal for agriculture, with a soil rich in potassium.");

		bases.get(2).setName("Pisces (Stockholm)");
		bases.get(2).setGeoLocation("{ \"lon\": 18.06216022  , \"lat\" : 59.3294824 } ");
		bases.get(2).setCode("Stockholm-Pisces");
		bases.get(2).setDescription("The Pisces base is managed by Stockholm. "
				+ "The first settlers, led by Jean-Luc Picard, planted the flag in Olympus Mons.\n"
				+ "The base offers a wonderful landscape around the Olympus Mons which offers a natural watchtower.\n"
				+ "The place is used as a refinery thanks to blast furnaces.");

		bases.get(3).setName("Cygnus (Copenhagen)");
		bases.get(3).setGeoLocation("{ \"lon\": 12.568337 , \"lat\" : 55.676098 } ");
		bases.get(3).setCode("Copenhagen-Cygnus");
		bases.get(3).setDescription("The Cygnus base is managed by Copenhagen. "
				+ "The first settlers, led by Darth Vader, planted the flag in Tharsis.\n"
				+ "The base offers a wonderful maritime landscape and is well-known for its seaside resort and its retirement house\n"
				+ "The place is used as a rest place.");

		bases.get(4).setName("Dragon (Roma)");
		bases.get(4).setGeoLocation("{ \"lon\": 12.48327333 , \"lat\" : 41.89988 } ");
		bases.get(4).setCode("Roma-Dragon");
		bases.get(4).setDescription("The Dragon base is managed by Roma."
				+ " The first settlers, led by Han Solo, planted the flag in a crater, near a frozen lake.\n"
				+ "The crater is one kilometer deep, which offers a mountain-like landscape.\n"
				+ "The place is rich in minerals, especially in antimony.");

		bases.get(5).setName("Andromeda (London)");
		bases.get(5).setGeoLocation("{ \"lon\": -0.1255 , \"lat\" : 51.5084 }");
		bases.get(5).setCode("London-Andromeda");
		bases.get(5).setDescription("The Andromeda base is managed by London. "
				+ "The first settlers, led by Jim Lovell, planted the flag near Utopia Planitia.\n"
				+ "The area is flat and several kilometers long.\n"
				+ "The place is ideal for agriculture, with a soil rich in potassium.");

		bases.get(6).setName("Proxima (Barcelona)");
		bases.get(6).setGeoLocation("{ \"lon\": 2.166117778 , \"lat\" : 41.38961111 } ");
		bases.get(6).setCode("Barcelona-Proxima");
		bases.get(6).setDescription("The Proxima base is managed by Barcelona. "
				+ "The first settlers, led by William Adama, planted the flag in Olympus Mons.\n"
				+ "The base offers a wonderful landscape around the Olympus Mons which offers a natural watchtower.\n"
				+ "The place is used as a refinery thanks to blast furnaces.");

		bases.get(7).setName("Cassiopeiae (Hamburg)");
		bases.get(7).setGeoLocation("{ \"lon\": 10.002914 , \"lat\" : 53.561012 } ");
		bases.get(7).setCode("Hamburg-Cassiopeiae");
		bases.get(7).setDescription("The Cassiopeiae base is managed by Hamburg. "
				+ "The first settlers, led by HAL, planted the flag in Tharsis.\n"
				+ "The base offers a wonderful maritime landscape and is well-known for its seaside resort and its retirement house\n"
				+ "The place is used as a rest place.");

		bases.get(8).setName("Persei (Moscow)");
		bases.get(8).setGeoLocation("{ \"lon\": -4.3833 , \"lat\" : 55.5833 }");
		bases.get(8).setCode("Moscow-Persei");
		bases.get(8).setDescription("The Persei base is managed by Moscow."
				+ " The first settlers, led by Arthur Dallas, planted the flag in a crater, near a frozen lake.\n"
				+ "The crater is one kilometer deep, which offers a mountain-like landscape.\n"
				+ "The place is rich in minerals, especially in antimony.");

		bases.get(9).setName("Pegasus (Munich)");
		bases.get(9).setGeoLocation("{ \"lon\": 11.576124 , \"lat\" : 48.137154 } ");
		bases.get(9).setCode("Munich-Pegasus");
		bases.get(9).setDescription("The Pegasus base is managed by Munich. "
				+ "The first settlers, led by Ellen Louise Ripley, planted the flag near Utopia Planitia.\n"
				+ "The area is flat and several kilometers long.\n"
				+ "The place is ideal for agriculture, with a soil rich in potassium.");

		int baseIdx = 0;
		for (final Base base : bases) {
			baseDAO.create(base);
			baseIdx++;

			//Add picture

			for (final String picturePath : builder.generatePictures(baseIdx)) {
				final VFile pictureFile = fileManager.createFile(
						picturePath.substring(picturePath.lastIndexOf('/') + 1),
						"image/" + picturePath.substring(picturePath.lastIndexOf('.') + 1),
						this.getClass().getResource(picturePath));

				final FileInfo fileInfo = storeManager.getFileStore().create(new FileInfoStd(pictureFile));

				final Picture picture = new Picture();
				picture.setBaseId(base.getBaseId());
				picture.setPicturefileId((Long) fileInfo.getURI().getKey());
				pictureDAO.create(picture);
			}
		}
		return bases;

	}

}
