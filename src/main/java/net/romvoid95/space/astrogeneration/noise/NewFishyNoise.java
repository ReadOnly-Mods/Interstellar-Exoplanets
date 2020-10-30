/**
 * Copyright (C) 2020 Interstellar:  Exoplanets
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.romvoid95.space.astrogeneration.noise;

import java.util.Random;

public class NewFishyNoise {
	int[] perm = new int[512];

	public float[][] grad2d = new float[][] { 
		{ 0.130526192220052F,  0.99144486137381F},
		{ 0.38268343236509F,   0.923879532511287F},
		{ 0.608761429008721F,  0.793353340291235F},
		{ 0.793353340291235F,  0.608761429008721F},
		{ 0.923879532511287F,  0.38268343236509F},
		{ 0.99144486137381F,   0.130526192220051F},
		{ 0.99144486137381F,  -0.130526192220051F},
		{ 0.923879532511287F, -0.38268343236509F},
		{ 0.793353340291235F, -0.60876142900872F},
		{ 0.608761429008721F, -0.793353340291235F},
		{ 0.38268343236509F,  -0.923879532511287F},
		{ 0.130526192220052F, -0.99144486137381F},
		{-0.130526192220052F, -0.99144486137381F},
		{-0.38268343236509F,  -0.923879532511287F},
		{-0.608761429008721F, -0.793353340291235F},
		{-0.793353340291235F, -0.608761429008721F},
		{-0.923879532511287F, -0.38268343236509F},
		{-0.99144486137381F,  -0.130526192220052F},
		{-0.99144486137381F,   0.130526192220051F},
		{-0.923879532511287F,  0.38268343236509F},
		{-0.793353340291235F,  0.608761429008721F},
		{-0.608761429008721F,  0.793353340291235F},
		{-0.38268343236509F,   0.923879532511287F},
		{-0.130526192220052F,  0.99144486137381F}						
	};
	
	public double[][] grad3d = new double[][] {
		{0.1453787434, -0.4149781685, -0.0956981749},
		{-0.01242829687, -0.1457918398, -0.4255470325},
		{0.2877979582, -0.02606483451, -0.3449535616},
		{-0.07732986802, 0.2377094325, 0.3741848704},
		{0.1107205875, -0.3552302079, -0.2530858567},
		{0.2755209141, 0.2640521179, -0.238463215},
		{0.294168941, 0.1526064594, 0.3044271714},
		{0.4000921098, -0.2034056362, 0.03244149937},
		{-0.1697304074, 0.3970864695, -0.1265461359},
		{-0.1483224484, -0.3859694688, 0.1775613147},
		{0.2623596946, -0.2354852944, 0.2796677792},
		{-0.2709003183, 0.3505271138, -0.07901746678},
		{-0.03516550699, 0.3885234328, 0.2243054374},
		{-0.1267712655, 0.1920044036, 0.3867342179},
		{0.02952021915, 0.4409685861, 0.08470692262},
		{-0.2806854217, -0.266996757, 0.2289725438},
		{-0.171159547, 0.2141185563, 0.3568720405},
		{0.2113227183, 0.3902405947, -0.07453178509},
		{-0.1024352839, 0.2128044156, -0.3830421561},
		{-0.3304249877, -0.1566986703, 0.2622305365},
		{0.2091111325, 0.3133278055, -0.2461670583},
		{0.344678154, -0.1944240454, -0.2142341261},
		{0.1984478035, -0.3214342325, -0.2445373252},
		{-0.2929008603, 0.2262915116, 0.2559320961},
		{-0.1617332831, 0.006314769776, -0.4198838754},
		{-0.3582060271, -0.148303178, -0.2284613961},
		{-0.1852067326, -0.3454119342, -0.2211087107},
		{0.3046301062, 0.1026310383, 0.314908508},
		{-0.03816768434, -0.2551766358, -0.3686842991},
		{-0.4084952196, 0.1805950793, 0.05492788837},
		{-0.02687443361, -0.2749741471, 0.3551999201},
		{-0.03801098351, 0.3277859044, 0.3059600725},
		{0.2371120802, 0.2900386767, -0.2493099024},
		{0.4447660503, 0.03946930643, 0.05590469027},
		{0.01985147278, -0.01503183293, -0.4493105419},
		{0.4274339143, 0.03345994256, -0.1366772882},
		{-0.2072988631, 0.2871414597, -0.2776273824},
		{-0.3791240978, 0.1281177671, 0.2057929936},
		{-0.2098721267, -0.1007087278, -0.3851122467},
		{0.01582798878, 0.4263894424, 0.1429738373},
		{-0.1888129464, -0.3160996813, -0.2587096108},
		{0.1612988974, -0.1974805082, -0.3707885038},
		{-0.08974491322, 0.229148752, -0.3767448739},
		{0.07041229526, 0.4150230285, -0.1590534329},
		{-0.1082925611, -0.1586061639, 0.4069604477},
		{0.2474100658, -0.3309414609, 0.1782302128},
		{-0.1068836661, -0.2701644537, -0.3436379634},
		{0.2396452163, 0.06803600538, -0.3747549496},
		{-0.3063886072, 0.2597428179, 0.2028785103},
		{0.1593342891, -0.3114350249, -0.2830561951},
		{0.2709690528, 0.1412648683, -0.3303331794},
		{-0.1519780427, 0.3623355133, 0.2193527988},
		{0.1699773681, 0.3456012883, 0.2327390037},
		{-0.1986155616, 0.3836276443, -0.1260225743},
		{-0.1887482106, -0.2050154888, -0.353330953},
		{0.2659103394, 0.3015631259, -0.2021172246},
		{-0.08838976154, -0.4288819642, -0.1036702021},
		{-0.04201869311, 0.3099592485, 0.3235115047},
		{-0.3230334656, 0.201549922, -0.2398478873},
		{0.2612720941, 0.2759854499, -0.2409749453},
		{0.385713046, 0.2193460345, 0.07491837764},
		{0.07654967953, 0.3721732183, 0.241095919},
		{0.4317038818, -0.02577753072, 0.1243675091},
		{-0.2890436293, -0.3418179959, -0.04598084447},
		{-0.2201947582, 0.383023377, -0.08548310451},
		{0.4161322773, -0.1669634289, -0.03817251927},
		{0.2204718095, 0.02654238946, -0.391391981},
		{-0.1040307469, 0.3890079625, -0.2008741118},
		{-0.1432122615, 0.371614387, -0.2095065525},
		{0.3978380468, -0.06206669342, 0.2009293758},
		{-0.2599274663, 0.2616724959, -0.2578084893},
		{0.4032618332, -0.1124593585, 0.1650235939},
		{-0.08953470255, -0.3048244735, 0.3186935478},
		{0.118937202, -0.2875221847, 0.325092195},
		{0.02167047076, -0.03284630549, -0.4482761547},
		{-0.3411343612, 0.2500031105, 0.1537068389},
		{0.3162964612, 0.3082064153, -0.08640228117},
		{0.2355138889, -0.3439334267, -0.1695376245},
		{-0.02874541518, -0.3955933019, 0.2125550295},
		{-0.2461455173, 0.02020282325, -0.3761704803},
		{0.04208029445, -0.4470439576, 0.02968078139},
		{0.2727458746, 0.2288471896, -0.2752065618},
		{-0.1347522818, -0.02720848277, -0.4284874806},
		{0.3829624424, 0.1231931484, -0.2016512234},
		{-0.3547613644, 0.1271702173, 0.2459107769},
		{0.2305790207, 0.3063895591, 0.2354968222},
		{-0.08323845599, -0.1922245118, 0.3982726409},
		{0.2993663085, -0.2619918095, -0.2103333191},
		{-0.2154865723, 0.2706747713, 0.287751117},
		{0.01683355354, -0.2680655787, -0.3610505186},
		{0.05240429123, 0.4335128183, -0.1087217856},
		{0.00940104872, -0.4472890582, 0.04841609928},
		{0.3465688735, 0.01141914583, -0.2868093776},
		{-0.3706867948, -0.2551104378, 0.003156692623},
		{0.2741169781, 0.2139972417, -0.2855959784},
		{0.06413433865, 0.1708718512, 0.4113266307},
		{-0.388187972, -0.03973280434, -0.2241236325},
		{0.06419469312, -0.2803682491, 0.3460819069},
		{-0.1986120739, -0.3391173584, 0.2192091725},
		{-0.203203009, -0.3871641506, 0.1063600375},
		{-0.1389736354, -0.2775901578, -0.3257760473},
		{-0.06555641638, 0.342253257, -0.2847192729},
		{-0.2529246486, -0.2904227915, 0.2327739768},
		{0.1444476522, 0.1069184044, 0.4125570634},
		{-0.3643780054, -0.2447099973, -0.09922543227},
		{0.4286142488, -0.1358496089, -0.01829506817},
		{0.165872923, -0.3136808464, -0.2767498872},
		{0.2219610524, -0.3658139958, 0.1393320198},
		{0.04322940318, -0.3832730794, 0.2318037215},
		{-0.08481269795, -0.4404869674, -0.03574965489},
		{0.1822082075, -0.3953259299, 0.1140946023},
		{-0.3269323334, 0.3036542563, 0.05838957105},
		{-0.4080485344, 0.04227858267, -0.184956522},
		{0.2676025294, -0.01299671652, 0.36155217},
		{0.3024892441, -0.1009990293, -0.3174892964},
		{0.1448494052, 0.425921681, -0.0104580805},
		{0.4198402157, 0.08062320474, 0.1404780841},
		{-0.3008872161, -0.333040905, -0.03241355801},
		{0.3639310428, -0.1291284382, -0.2310412139},
		{0.3295806598, 0.0184175994, -0.3058388149},
		{0.2776259487, -0.2974929052, -0.1921504723},
		{0.4149000507, -0.144793182, -0.09691688386},
		{0.145016715, -0.0398992945, 0.4241205002},
		{0.09299023471, -0.299732164, -0.3225111565},
		{0.1028907093, -0.361266869, 0.247789732},
		{0.2683057049, -0.07076041213, -0.3542668666},
		{-0.4227307273, -0.07933161816, -0.1323073187},
		{-0.1781224702, 0.1806857196, -0.3716517945},
		{0.4390788626, -0.02841848598, -0.09435116353},
		{0.2972583585, 0.2382799621, -0.2394997452},
		{-0.1707002821, 0.2215845691, 0.3525077196},
		{0.3806686614, 0.1471852559, -0.1895464869},
		{-0.1751445661, -0.274887877, 0.3102596268},
		{-0.2227237566, -0.2316778837, 0.3149912482},
		{0.1369633021, 0.1341343041, -0.4071228836},
		{-0.3529503428, -0.2472893463, -0.129514612},
		{-0.2590744185, -0.2985577559, -0.2150435121},
		{-0.3784019401, 0.2199816631, -0.1044989934},
		{-0.05635805671, 0.1485737441, 0.4210102279},
		{0.3251428613, 0.09666046873, -0.2957006485},
		{-0.4190995804, 0.1406751354, -0.08405978803},
		{-0.3253150961, -0.3080335042, -0.04225456877},
		{0.2857945863, -0.05796152095, 0.3427271751},
		{-0.2733604046, 0.1973770973, -0.2980207554},
		{0.219003657, 0.2410037886, -0.3105713639},
		{0.3182767252, -0.271342949, 0.1660509868},
		{-0.03222023115, -0.3331161506, -0.300824678},
		{-0.3087780231, 0.1992794134, -0.2596995338},
		{-0.06487611647, -0.4311322747, 0.1114273361},
		{0.3921171432, -0.06294284106, -0.2116183942},
		{-0.1606404506, -0.358928121, -0.2187812825},
		{-0.03767771199, -0.2290351443, 0.3855169162},
		{0.1394866832, -0.3602213994, 0.2308332918},
		{-0.4345093872, 0.005751117145, 0.1169124335},
		{-0.1044637494, 0.4168128432, -0.1336202785},
		{0.2658727501, 0.2551943237, 0.2582393035},
		{0.2051461999, 0.1975390727, 0.3484154868},
		{-0.266085566, 0.23483312, 0.2766800993},
		{0.07849405464, -0.3300346342, -0.2956616708},
		{-0.2160686338, 0.05376451292, -0.3910546287},
		{-0.185779186, 0.2148499206, 0.3490352499},
		{0.02492421743, -0.3229954284, -0.3123343347},
		{-0.120167831, 0.4017266681, 0.1633259825},
		{-0.02160084693, -0.06885389554, 0.4441762538},
		{0.2597670064, 0.3096300784, 0.1978643903},
		{-0.1611553854, -0.09823036005, 0.4085091653},
		{-0.3278896792, 0.1461670309, 0.2713366126},
		{0.2822734956, 0.03754421121, -0.3484423997},
		{0.03169341113, 0.347405252, -0.2842624114},
		{0.2202613604, -0.3460788041, -0.1849713341},
		{0.2933396046, 0.3031973659, 0.1565989581},
		{-0.3194922995, 0.2453752201, -0.200538455},
		{-0.3441586045, -0.1698856132, -0.2349334659},
		{0.2703645948, -0.3574277231, 0.04060059933},
		{0.2298568861, 0.3744156221, 0.0973588921},
		{0.09326603877, -0.3170108894, 0.3054595587},
		{-0.1116165319, -0.2985018719, 0.3177080142},
		{0.2172907365, -0.3460005203, -0.1885958001},
		{0.1991339479, 0.3820341668, -0.1299829458},
		{-0.0541918155, -0.2103145071, 0.39412061},
		{0.08871336998, 0.2012117383, 0.3926114802},
		{0.2787673278, 0.3505404674, 0.04370535101},
		{-0.322166438, 0.3067213525, 0.06804996813},
		{-0.4277366384, 0.132066775, 0.04582286686},
		{0.240131882, -0.1612516055, 0.344723946},
		{0.1448607981, -0.2387819045, 0.3528435224},
		{-0.3837065682, -0.2206398454, 0.08116235683},
		{-0.4382627882, -0.09082753406, -0.04664855374},
		{-0.37728353, 0.05445141085, 0.2391488697},
		{0.1259579313, 0.348394558, 0.2554522098},
		{-0.1406285511, -0.270877371, -0.3306796947},
		{-0.1580694418, 0.4162931958, -0.06491553533},
		{0.2477612106, -0.2927867412, -0.2353514536},
		{0.2916132853, 0.3312535401, 0.08793624968},
		{0.07365265219, -0.1666159848, 0.411478311},
		{-0.26126526, -0.2422237692, 0.2748965434},
		{-0.3721862032, 0.252790166, 0.008634938242},
		{-0.3691191571, -0.255281188, 0.03290232422},
		{0.2278441737, -0.3358364886, 0.1944244981},
		{0.363398169, -0.2310190248, 0.1306597909},
		{-0.304231482, -0.2698452035, 0.1926830856},
		{-0.3199312232, 0.316332536, -0.008816977938},
		{0.2874852279, 0.1642275508, -0.304764754},
		{-0.1451096801, 0.3277541114, -0.2720669462},
		{0.3220090754, 0.0511344108, 0.3101538769},
		{-0.1247400865, -0.04333605335, -0.4301882115},
		{-0.2829555867, -0.3056190617, -0.1703910946},
		{0.1069384374, 0.3491024667, -0.2630430352},
		{-0.1420661144, -0.3055376754, -0.2982682484},
		{-0.250548338, 0.3156466809, -0.2002316239},
		{0.3265787872, 0.1871229129, 0.2466400438},
		{0.07646097258, -0.3026690852, 0.324106687},
		{0.3451771584, 0.2757120714, -0.0856480183},
		{0.298137964, 0.2852657134, 0.179547284},
		{0.2812250376, 0.3466716415, 0.05684409612},
		{0.4390345476, -0.09790429955, -0.01278335452},
		{0.2148373234, 0.1850172527, 0.3494474791},
		{0.2595421179, -0.07946825393, 0.3589187731},
		{0.3182823114, -0.307355516, -0.08203022006},
		{-0.4089859285, -0.04647718411, 0.1818526372},
		{-0.2826749061, 0.07417482322, 0.3421885344},
		{0.3483864637, 0.225442246, -0.1740766085},
		{-0.3226415069, -0.1420585388, -0.2796816575},
		{0.4330734858, -0.118868561, -0.02859407492},
		{-0.08717822568, -0.3909896417, -0.2050050172},
		{-0.2149678299, 0.3939973956, -0.03247898316},
		{-0.2687330705, 0.322686276, -0.1617284888},
		{0.2105665099, -0.1961317136, -0.3459683451},
		{0.4361845915, -0.1105517485, 0.004616608544},
		{0.05333333359, -0.313639498, -0.3182543336},
		{-0.05986216652, 0.1361029153, -0.4247264031},
		{0.3664988455, 0.2550543014, -0.05590974511},
		{-0.2341015558, -0.182405731, 0.3382670703},
		{-0.04730947785, -0.4222150243, -0.1483114513},
		{-0.2391566239, -0.2577696514, -0.2808182972},
		{-0.1242081035, 0.4256953395, -0.07652336246},
		{0.2614832715, -0.3650179274, 0.02980623099},
		{-0.2728794681, -0.3499628774, 0.07458404908},
		{0.007892900508, -0.1672771315, 0.4176793787},
		{-0.01730330376, 0.2978486637, -0.3368779738},
		{0.2054835762, -0.3252600376, -0.2334146693},
		{-0.3231994983, 0.1564282844, -0.2712420987},
		{-0.2669545963, 0.2599343665, -0.2523278991},
		{-0.05554372779, 0.3170813944, -0.3144428146},
		{-0.2083935713, -0.310922837, -0.2497981362},
		{0.06989323478, -0.3156141536, 0.3130537363},
		{0.3847566193, -0.1605309138, -0.1693876312},
		{-0.3026215288, -0.3001537679, -0.1443188342},
		{0.3450735512, 0.08611519592, 0.2756962409},
		{0.1814473292, -0.2788782453, -0.3029914042},
		{-0.03855010448, 0.09795110726, 0.4375151083},
		{0.3533670318, 0.2665752752, 0.08105160988},
		{-0.007945601311, 0.140359426, -0.4274764309},
		{0.4063099273, -0.1491768253, -0.1231199324},
		{-0.2016773589, 0.008816271194, -0.4021797064},
		{-0.07527055435, -0.425643481, -0.1251477955}
	};

//	public double[][] grad3d = new double[][] { 
//		{-2.22474487139,      -2.22474487139,      -1.0},
//		{-2.22474487139,      -2.22474487139,       1.0},
//		{-3.0862664687972017, -1.1721513422464978,  0.0},
//		{-1.1721513422464978, -3.0862664687972017,  0.0},
//		{-2.22474487139,      -1.0,                -2.22474487139},
//		{-2.22474487139,       1.0,                -2.22474487139},
//		{-1.1721513422464978,  0.0,                -3.0862664687972017},
//		{-3.0862664687972017,  0.0,                -1.1721513422464978},
//		{-2.22474487139,      -1.0,                 2.22474487139},
//		{-2.22474487139,       1.0,                 2.22474487139},
//		{-3.0862664687972017,  0.0,                 1.1721513422464978},
//		{-1.1721513422464978,  0.0,                 3.0862664687972017},
//		{-2.22474487139,       2.22474487139,      -1.0},
//		{-2.22474487139,       2.22474487139,       1.0},
//		{-1.1721513422464978,  3.0862664687972017,  0.0},
//		{-3.0862664687972017,  1.1721513422464978,  0.0},
//		{-1.0,                -2.22474487139,      -2.22474487139},
//		{ 1.0,                -2.22474487139,      -2.22474487139},
//		{ 0.0,                -3.0862664687972017, -1.1721513422464978},
//		{ 0.0,                -1.1721513422464978, -3.0862664687972017},
//		{-1.0,                -2.22474487139,       2.22474487139},
//		{ 1.0,                -2.22474487139,       2.22474487139},
//		{ 0.0,                -1.1721513422464978,  3.0862664687972017},
//		{ 0.0,                -3.0862664687972017,  1.1721513422464978},
//		{-1.0,                 2.22474487139,      -2.22474487139},
//		{ 1.0,                 2.22474487139,      -2.22474487139},
//		{ 0.0,                 1.1721513422464978, -3.0862664687972017},
//		{ 0.0,                 3.0862664687972017, -1.1721513422464978},
//		{-1.0,                 2.22474487139,       2.22474487139},
//		{ 1.0,                 2.22474487139,       2.22474487139},
//		{ 0.0,                 3.0862664687972017,  1.1721513422464978},
//		{ 0.0,                 1.1721513422464978,  3.0862664687972017},
//		{ 2.22474487139,      -2.22474487139,      -1.0},
//		{ 2.22474487139,      -2.22474487139,       1.0},
//		{ 1.1721513422464978, -3.0862664687972017,  0.0},
//		{ 3.0862664687972017, -1.1721513422464978,  0.0},
//		{ 2.22474487139,      -1.0,                -2.22474487139},
//		{ 2.22474487139,       1.0,                -2.22474487139},
//		{ 3.0862664687972017,  0.0,                -1.1721513422464978},
//		{ 1.1721513422464978,  0.0,                -3.0862664687972017},
//		{ 2.22474487139,      -1.0,                 2.22474487139},
//		{ 2.22474487139,       1.0,                 2.22474487139},
//		{ 1.1721513422464978,  0.0,                 3.0862664687972017},
//		{ 3.0862664687972017,  0.0,                 1.1721513422464978},
//		{ 2.22474487139,       2.22474487139,      -1.0},
//		{ 2.22474487139,       2.22474487139,       1.0},
//		{ 3.0862664687972017,  1.1721513422464978,  0.0},
//		{ 1.1721513422464978,  3.0862664687972017,  0.0}
//	};

	public NewFishyNoise (long seed) {
		final Random rand = new Random(seed);
		for (int i = 0; i < 256; i++) {
			this.perm[i] = i;
		}

		for (int i = 0; i < 256; i++)
		{
			final int j = rand.nextInt(256);
			this.perm[i] = this.perm[i] ^ this.perm[j];
			this.perm[j] = this.perm[i] ^ this.perm[j];
			this.perm[i] = this.perm[i] ^ this.perm[j];
		}

		System.arraycopy(this.perm, 0, this.perm, 256, 256);
	}

	public float noise2d(float x, float y) {
		int largeX = x > 0 ? (int) x : (int) x - 1;
		int largeY = y > 0 ? (int) y : (int) y - 1;
		x -= largeX;
		y -= largeY;
		largeX &= 255;
		largeY &= 255;

		final float u = x * x * x * (x * (x * 6 - 15) + 10);
		final float v = y * y * y * (y * (y * 6 - 15) + 10);

		int randY = this.perm[largeY] + largeX;
		int randY1 = this.perm[largeY + 1] + largeX;
		float[] grad2 = this.grad2d[this.perm[randY] & 15];
		final float grad00 = grad2[0] * x + grad2[1] * y;
		grad2 = this.grad2d[this.perm[randY1] & 15];
		final float grad01 = grad2[0] * x + grad2[1] * (y - 1);
		grad2 = this.grad2d[this.perm[1 + randY1] & 15];
		final float grad11 = grad2[0] * (x - 1) + grad2[1] * (y - 1);
		grad2 = this.grad2d[this.perm[1 + randY] & 15];
		final float grad10 = grad2[0] * (x - 1) + grad2[1] * y;

		final float lerpX0 = grad00 + u * (grad10 - grad00);
		return lerpX0 + v * (grad01 + u * (grad11 - grad01) - lerpX0);
	}

	public float noise3d(float x, float y, float z) {
		int unitX = x > 0 ? (int) x : (int) x - 1;
		int unitY = y > 0 ? (int) y : (int) y - 1;
		int unitZ = z > 0 ? (int) z : (int) z - 1;

		x -= unitX;
		y -= unitY;
		z -= unitZ;

		unitX &= 255;
		unitY &= 255;
		unitZ &= 255;

		final float u = x * x * x * (x * (x * 6 - 15) + 10);
		final float v = y * y * y * (y * (y * 6 - 15) + 10);
		final float w = z * z * z * (z * (z * 6 - 15) + 10);

		int randZ = this.perm[unitZ] + unitY;
		int randZ1 = this.perm[unitZ + 1] + unitY;
		int randYZ = this.perm[randZ] + unitX;
		int randY1Z = this.perm[1 + randZ] + unitX;
		int randYZ1 = this.perm[randZ1] + unitX;
		int randY1Z1 = this.perm[1 + randZ1] + unitX;
		double[] grad3 = this.grad3d[this.perm[randYZ] & 15];
		final float grad000 = (float) (grad3[0] * x + grad3[1] * y + grad3[2] * z);
		grad3 = this.grad3d[this.perm[1 + randYZ] & 15];
		final double grad100 = grad3[0] * (x - 1) + grad3[1] * y + grad3[2] * z;
		grad3 = this.grad3d[this.perm[randY1Z] & 15];
		final double grad010 = grad3[0] * x + grad3[1] * (y - 1) + grad3[2] * z;
		grad3 = this.grad3d[this.perm[1 + randY1Z] & 15];
		final double grad110 = grad3[0] * (x - 1) + grad3[1] * (y - 1) + grad3[2] * z;
		z--;
		grad3 = this.grad3d[this.perm[randYZ1] & 15];
		final double grad001 = grad3[0] * x + grad3[1] * y + grad3[2] * z;
		grad3 = this.grad3d[this.perm[1 + randYZ1] & 15];
		final double grad101 = grad3[0] * (x - 1) + grad3[1] * y + grad3[2] * z;
		grad3 = this.grad3d[this.perm[randY1Z1] & 15];
		final double grad011 = grad3[0] * x + grad3[1] * (y - 1) + grad3[2] * z;
		grad3 = this.grad3d[this.perm[1 + randY1Z1] & 15];
		final double grad111 = grad3[0] * (x - 1) + grad3[1] * (y - 1) + grad3[2] * z;

		double f1 = grad000 + u * (grad100 - grad000);
		double f2 = grad010 + u * (grad110 - grad010);
		double f3 = grad001 + u * (grad101 - grad001);
		double f4 = grad011 + u * (grad111 - grad011);
		double lerp1 = f1 + v * (f2 - f1);
		return (float) (lerp1 + w * (f3 + v * (f4 - f3) - lerp1));
	}

}
