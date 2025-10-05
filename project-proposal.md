# Sistemi Bazirani na Znanju - Predlog Projekta

## Optimizacija Potrošnje Električne Energije u Smart Home Sistemu

### Članovi tima

- Dragoslav Tamindžija - SV47/2021
- Darko Svilar - SV50/2021

### Motivacija

U dobu Interneta i elektronskih uređaja, automatizovani kućni IoT sistemi postaju sve popularniji. To su sistemi u kojima komponente troše električnu energiju tokom celog dana.

Sa povećanom svesti o reperkusijama po prirodu koje potrošnja električne energije može da ima, kao i lična potreba za štednjom novca, jasno je da štednja električne energije u domaćinstvima koje koriste IoT sistem kao gore-navedeni postaje važan cilj individualcu.

Dosadašnja softverska rešenja ovakvom problemu su se pokazala kao nedovoljna, zato što se fokusiraju na određeni podskup uređaja, bilo određenog proizvođača, ili namene. Ovo obično rezultuje u neoptimalnom upravljanju uređajima, jer softversko rešenje ima manjak informacija o ostatku sistema unutar domaćinstva.

Naše rešenje bi bilo celovito, na nivou domaćinstva, i nudilo bi adaptibilno ponašanje na osnovu trenutnih uslova u domaćinstvu, vremenskih uslova, dostupnosti drugih izvora električne energije...

### Pregled problema

Problem koje naše softversko rešenje nastoji da reši je optimizacija potrošnje električne energije u okviru kućnog IoT sistema, u zavisnosti od trenutnih uslova u domaćinstvu, vremenskih uslova, prisustva ljudi u domaćinstvu i kompleksnih uslova koji se stvaraju kao rezultat interakcije komponentata smart home sistema.

Neka od postojećih konkurentih sistema i njihovi opisi su:

- Nest - Smart termostat. Mana je što upravlja samo grejnim i rashladnim uređajima u domaćinstvu.
- EcoBee - Slično kao Nest...
- Samsung SmartThings - Samsungovo rešenje za upravljanje samo onim home IoT uređajima koje su oni proizveli.

Dosadašnja akademska istraživanja pokazuju da je, u proseku, moguće smanjiti potrošnju 15-30% kroz inteligentno upravljanje uređajima u domaćinstvu.

Neke od prednosti našeg rešenja u odnosu na ostala su:

- Holistički pristup softverskom rešenju - Optimizacija potrošnje energije se vrši na nivou celog domaćinstva, sa osvrtom na interakcije uređaja unutar sistema.
- Dinamička adaptacija - Sistem ima sposobnost da se prilagodi promenama koje se dešavaju u realnom vremenu.
- Proširivost - Mogućnost dodavanja novih uređaja u sistem i novih pravila u rule engine.

### Ulazi u sistem

Ulazni podaci u sistem se dele na podatke koje strimuju senzori i spoljne podatke unete u sistem.

Podaci koje strimuju senzori mogu biti:

- Temperatura
- Vlažnost vazduha
- Osvetljenost
- Prisustvo ljudi u domaćinstvu
- Zagađenost vazduha
- Stanje rezervnih solarnih baterija (koliko je napunjena)

Spoljni podaci uneti u sistem su:

- Trenutno stanje rada uređaja (uključen/isključen)
- Status baterije uređaja koji se pune
- Potrošnja uređaja

### Izlazi iz sistema

Izlazi iz sistema bi bili:

- Uključivanje/Isključivanje uređaja
- Kontrola rada podesivih uređaja (intenzitet, boje...)
- Kontrola rada intenzivnih potrošača
- Prebacivanje na rezervno napajanje

### Baza znanja

Baza znanja sistema se sastoji iz više skupova pravila.

1. Pravila za optimizaciju potrošnje:

```
when prisustvo_ukucana == false
then
    smanji_grejanje && iskljuci_uređaje
```

```
when prisustvo_ukucana == true
then
    pojacaj_grejanje
```

```
when profil_potrosnje == "Nocni" && prisustvo_ukucana == false
then
	// Ves masina, punjac za elektricni auto, itd...
	ukljuci_vremenski_intenzivne_potrosace
```

```
when profil_potrosnje == "Balansirani" && prisustvo_ukucana == true
then
	ukljuci_sve_uredjaje && pojacaj_rad_uredjaja
```

2. Pravila za upravljanje rezervnim izvorima energije:

```
when kapacitet_solarne_baterije > 80 && solarna_proizvodnja > trenutna_potrosnja
then
    prebaci_potrosnju_na_rezerve
```

```
when kapacitet_solarne_baterije < 30
then
	prebaci_potrosnju_na_mrezu
```

3. Pravila zasnovana na profilima potrošnje:

```
when profil == "Nocni rezim"
then
    aktiviraj_intenzivne_potrosace
```

```
when profil == "Stednja"
then
	deaktiviraj_intenzivne_potrosace
	smanji_intenzitet_rada_potrosaca
```

```
when profil == "Balansiran"
then
	usrednji_rad_potrosaca
```

#### Popunjavanje baze znanja

Inicijalno, baza znanja bi bila popunjena pravilima definisanim na osnovu ekspertskog znanja i najboljih praksi iz literature.

Takođe, baza znanja može biti dopunjena, pravilima koja se zasnivaju na novim uređajima, novim profilima potrošnje...

#### Interakcije na osnovu znanja iz baze

Sistem proaktivno primenjuje optimizacije na osnovu trenutnih podataka koje unese korisnik.

Takođe, sistem može reagovati na promene u okruženju, inicirane od strane korisnika, ili na promene koje se prirodno dešavaju, kao što je proticanje vremena.

### Primer rezonovanja

Scenario je da je radni dan i nema nikoga u domaćinstvu. O domaćinstvu je poznato sledeće:

- Temperatura - 22°C
- Solarna proizvodnja - 3.2kW
- Potrošnja - 1.8kW

#### Primer Forward Chaining-a:

Korak 1:

```
when prisustvo_ukucana == false
then
	aktiviraj_profil_stednje

when solarna_proizvodnja > trenutna_potrosnja
then
	prebaci_potrosnju_na_rezerve
```

Korak 2:

```
when profil == "Stednja" && temperatura > sobna_temperatura
then
	smanji_grejanje

when rezim_rada == "Rezerve" && kapacitet_solarne_baterije < 30
then
	prebaci_potrosnju_na_mrezu
```

Korak 3:

```
when temperatura < sobna_temperatura - 2 && profil == "Dolazak sa posla"
then
	povecaj_grejanje

when rezim_rada = "Mreza" && elektricno_vozilo_povezano == true
then
	odlozi_punjenje_vozila
```

#### Primeri Accumulate funkcija i CEP-a (Complex Event Processing)

Kako sistem raspolaže očitavanjima električne energije generisane od strane solarnih panela, može izračunati koliko energije je sačuvano na dan koristeći solarnu energiju.

```
when
	$solarReadings: List() from collect(
		SolarPanelReading() over window:time(24h)
	)
	$totalPower: Double() from accumulate(
		SolarPanelReading($power: generatedPower) from $solarReadings,
		sum($power)
	)
then
	System.out.println("Summed power generated is" + $total);
```

CEP se takođe u ovom sistemu može iskoristiti da bi se tokom naglih promena vremenskih uslova moglo zaključiti da će u budućnosti biti dostupna veća količina solarne energije, te na osnovu toga olakšati kriterijume potrošnje.

```
when
	$weatherReadings: List(size >= 3) from collect(
		WeatherReading() over window:time(1h)
	)

	eval(checkDecreasingTrendInCloudCoverage($weatherReadings))
then
	prebaci_potrosnju_na_rezerve
```

#### Primer Template-a

Pomoću Template-a, moguće je korisniku omogućiti da generiše nova pravila u bazi znanja, tako što će moći da unosi nove profile potrošnje, i za njih definiše ciljane parametre domaćinstva koje želi da kućni IoT sistem postigne.

Naravno, parametre domaćinstva će biti potrebno donekle generalizovati, jer bi iskustvo korišćenja IoT sistema trebalo da bude maksimalno uprošćeno za prosečnog korisnika.

Na primer, tokom kreiranja noćnog režima rada, korisnik bi definisao da želi da u domaćinstvu bude toplije, da je osvetljenje minimalno i da vlažnost vazduha bude visoka, i ništa mnogo više od toga.

#### Primer Backward Chaining-a

Kako je cilj našeg sistema da što više uštedi električnu energiju, ali da kućni IoT sistem i dalje ostane visoko efikasan, primer Backward Chaining-a bi mogao biti da se za određeni naredni period pronađe energetski efikasno rešenje zagrevanja ili hlađenja sobe, kombinujući električnu energiju mreže i solarnu energiju akumuliranu u bateriji.

Cilj bi bio obezbediti da u domaćinstvu bude postignuta određena temperatura, ali, to postići maksimizovanjem potrošnje energije akumulirane u bateriji.

Konkretno, algoritmu bi se zadala lista svih uređaja čija je svrha grejanje, to jest, hlađenje. Pored toga, zadavali bi se i temperaturni cilj, dozvoljeni budžet baterija i dozvoljeni budžet mreže (u svrhu ograničenja potrošnje, zbog energetske efikasnosti). Algoritam bi uvek preferirao napajanje sa baterije, pre nego što krene da troši resurse sa mreže.

```
query canMeetGoal(int targetTemp, List<Device> devices, int batteryBudget, int gridBudget)
	if targetTemp <= getCurrentTemp()
		return true;

	if devices.isEmpty()
		return false;

	for $d in devices:
		$rest: devices.remove($d);
		$cons: $d.getConsumption();
		$effect: $d.getTempEffect();

		if batteryBudget >= $cons &&
                   canMeetGoal(
                           targetTemp - $effect,
                           $rest,
                           batteryBudget - $cons,
                           gridBudget
		   )
			return true;

		if gridBudget >= $cons &&
                   canMeetGoal(
                           targetTemp - $effect,
                           $rest,
                           batteryBudget,
                           gridBudget - $cons
                   )
			return true;

		if canMeetGoal(targetTemp, $rest, batteryBudget, gridBudget)
			return true;

	return false;
```

```
when
	heatingGoal: HeatingGoal(
		$targetTemp: targetTemp,
		$availableDevices: plannedDevices,
		$batteryBudget: batteryBudget,
		$gridBudget: gridBudget
	)
	canMeetGoal($targetTemp, $availableDevices, $batteryBudget, $gridBudget)
then
	System.out.println("Goal achievable!")
```
