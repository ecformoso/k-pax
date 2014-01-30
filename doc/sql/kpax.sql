-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-01-2014 a las 12:01:35
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `kpax`
--

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `adminview`
--
CREATE TABLE IF NOT EXISTS `adminview` (
`idGame` int(11)
,`name` varchar(255)
,`grantPublicAccess` tinyint(1)
,`secretGame` varchar(150)
,`privateKey` text
,`idCategory` int(11)
,`creationdate` timestamp
,`idstate` int(11)
,`idplatform` int(11)
,`idowner` int(11)
);
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `idCategory` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`idCategory`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `name_2` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`idCategory`, `name`) VALUES
(1, 'mathematics'),
(2, 'physics');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `idComment` int(11) NOT NULL AUTO_INCREMENT,
  `idGame` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idComment`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `developer`
--

CREATE TABLE IF NOT EXISTS `developer` (
  `idgame` int(11) NOT NULL,
  `idstate` int(11) NOT NULL,
  `idplatform` int(11) NOT NULL,
  `idowner` int(11) NOT NULL,
  PRIMARY KEY (`idgame`),
  UNIQUE KEY `alias_UNIQUE` (`idgame`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Estructura de tabla para la tabla `game`
--

CREATE TABLE IF NOT EXISTS `game` (
  `idGame` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `grantPublicAccess` tinyint(1) DEFAULT '1',
  `secretGame` varchar(150) DEFAULT NULL,
  `privateKey` text,
  `idCategory` int(11) DEFAULT '0',
  `creationDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idGame`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=129 ;


--
-- Estructura de tabla para la tabla `gameaccess`
--

CREATE TABLE IF NOT EXISTS `gameaccess` (
  `idGroup` int(11) NOT NULL,
  `idGame` int(11) NOT NULL,
  `type` varchar(10) NOT NULL DEFAULT 'allow',
  `recursive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`idGroup`,`idGame`),
  KEY `GameAccess_Group` (`idGroup`),
  KEY `GameAccess_Game` (`idGame`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gameinstance`
--

CREATE TABLE IF NOT EXISTS `gameinstance` (
  `idGameInstance` int(11) NOT NULL AUTO_INCREMENT,
  `idGame` int(11) NOT NULL,
  `state` longtext,
  PRIMARY KEY (`idGameInstance`),
  KEY `GameInstance_Game` (`idGame`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gamelike`
--

CREATE TABLE IF NOT EXISTS `gamelike` (
  `likeId` int(11) NOT NULL AUTO_INCREMENT,
  `gameId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `containerId` int(11) NOT NULL,
  PRIMARY KEY (`likeId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gamescore`
--

CREATE TABLE IF NOT EXISTS `gamescore` (
  `idScore` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `idGame` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  PRIMARY KEY (`idScore`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `gamesimilitudeview`
--
CREATE TABLE IF NOT EXISTS `gamesimilitudeview` (
`idGame` int(11)
,`similarToIdGame` int(11)
,`similitude` varchar(255)
);
-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `gameview`
--
CREATE TABLE IF NOT EXISTS `gameview` (
`idGame` int(11)
,`name` varchar(255)
,`grantPublicAccess` tinyint(1)
,`secretGame` varchar(150)
,`privateKey` text
,`idCategory` int(11)
,`creationDate` timestamp
,`timesCommented` bigint(21)
,`popularity` bigint(21)
,`timesPlayed` bigint(21)
,`activity` bigint(21)
);
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `group`
--

CREATE TABLE IF NOT EXISTS `group` (
  `idGroup` int(11) NOT NULL,
  `description` longtext,
  `idGroupParent` int(11) DEFAULT NULL,
  PRIMARY KEY (`idGroup`),
  KEY `GROUP_GROUP` (`idGroupParent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platform`
--

CREATE TABLE IF NOT EXISTS `platform` (
  `idPlatform` int(11) NOT NULL AUTO_INCREMENT,
  `platform` char(15) NOT NULL,
  PRIMARY KEY (`idPlatform`),
  UNIQUE KEY `alias_UNIQUE` (`platform`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `platform`
--

INSERT INTO `platform` (`idPlatform`, `platform`) VALUES
(2, 'android'),
(3, 'IOS'),
(4, 'Nintendo DS'),
(6, 'Nintendo Wii'),
(5, 'PSP'),
(1, 'web'),
(7, 'Xbox');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `realm`
--

CREATE TABLE IF NOT EXISTS `realm` (
  `idRealm` int(11) NOT NULL AUTO_INCREMENT,
  `alias` char(15) NOT NULL,
  PRIMARY KEY (`idRealm`),
  UNIQUE KEY `alias_UNIQUE` (`alias`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `realm`
--

INSERT INTO `realm` (`idRealm`, `alias`) VALUES
(1, 'ELGG');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `session`
--

CREATE TABLE IF NOT EXISTS `session` (
  `idSession` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `startTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `campusSession` varchar(250) NOT NULL,
  PRIMARY KEY (`idSession`),
  KEY `Session_User` (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `session`
--

INSERT INTO `session` (`idSession`, `idUser`, `startTime`, `campusSession`) VALUES
(1, 1, '2013-04-04 14:45:34', '7fc2fc4c330b69e3a579a10c279a2d3a14973054'),
(2, 2, '2013-04-04 15:33:05', 'b002da990eb7a058d2e9e18b86ea43fbbb367964'),
(3, 3, '2014-01-04 13:28:37', '20ccd5a959a987e52c1a3b35a309e7aff4d8f3d8');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `state`
--

CREATE TABLE IF NOT EXISTS `state` (
  `idState` int(11) NOT NULL AUTO_INCREMENT,
  `state` char(15) NOT NULL,
  PRIMARY KEY (`idState`),
  UNIQUE KEY `name_UNIQUE` (`state`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `state`
--

INSERT INTO `state` (`idState`, `state`) VALUES
(2, 'accepted'),
(3, 'denied'),
(1, 'requested');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tag`
--

CREATE TABLE IF NOT EXISTS `tag` (
  `idTag` int(11) NOT NULL AUTO_INCREMENT,
  `idGame` int(11) NOT NULL,
  `tag` varchar(255) NOT NULL,
  PRIMARY KEY (`idTag`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;


--
-- Estructura Stand-in para la vista `totalgamesimilitudeview`
--
CREATE TABLE IF NOT EXISTS `totalgamesimilitudeview` (
`idGame` int(11)
,`similarToIdGame` int(11)
,`totalSimilitude` bigint(21)
);
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `secret` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;


--
-- Estructura de tabla para la tabla `usergameinstance`
--

CREATE TABLE IF NOT EXISTS `usergameinstance` (
  `idUser` int(11) NOT NULL,
  `idGameInstance` int(11) NOT NULL,
  PRIMARY KEY (`idUser`,`idGameInstance`),
  KEY `UserGameInstance_User` (`idUser`),
  KEY `UserGameInstance_GameInstance` (`idGameInstance`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usergroup`
--

CREATE TABLE IF NOT EXISTS `usergroup` (
  `idUser` int(11) NOT NULL,
  `idGroup` int(11) NOT NULL,
  PRIMARY KEY (`idUser`,`idGroup`),
  KEY `UserGroup_User` (`idUser`),
  KEY `UserGroup_Group` (`idGroup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `userrealm`
--

CREATE TABLE IF NOT EXISTS `userrealm` (
  `idUser` int(11) NOT NULL,
  `idRealm` int(11) NOT NULL,
  PRIMARY KEY (`idUser`,`idRealm`),
  KEY `UserRealm_User` (`idUser`),
  KEY `UserRealm_Realm` (`idRealm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Estructura Stand-in para la vista `userview`
--
CREATE TABLE IF NOT EXISTS `userview` (
`idGame` int(11)
,`name` varchar(255)
,`grantPublicAccess` tinyint(1)
,`Category` varchar(255)
,`State` varchar(15)
,`Platform` varchar(15)
,`creationDate` timestamp
,`idowner` bigint(11)
);
-- --------------------------------------------------------

--
-- Estructura para la vista `adminview`
--
DROP TABLE IF EXISTS `adminview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `adminview` AS select `game`.`idGame` AS `idGame`,`game`.`name` AS `name`,`game`.`grantPublicAccess` AS `grantPublicAccess`,`game`.`secretGame` AS `secretGame`,`game`.`privateKey` AS `privateKey`,`game`.`idCategory` AS `idCategory`,`game`.`creationDate` AS `creationdate`,`developer`.`idstate` AS `idstate`,`developer`.`idplatform` AS `idplatform`,`developer`.`idowner` AS `idowner` from (`game` join `developer`) where (`game`.`idGame` = `developer`.`idgame`);

-- --------------------------------------------------------

--
-- Estructura para la vista `gamesimilitudeview`
--
DROP TABLE IF EXISTS `gamesimilitudeview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gamesimilitudeview` AS select `tag1`.`idGame` AS `idGame`,`tag2`.`idGame` AS `similarToIdGame`,`tag1`.`tag` AS `similitude` from (`tag` `tag1` join `tag` `tag2` on(((`tag1`.`tag` = `tag2`.`tag`) and (`tag1`.`idGame` <> `tag2`.`idGame`)))) union select `game1`.`idGame` AS `idGame`,`game2`.`idGame` AS `similarToIdGame`,`category`.`name` AS `similitude` from ((`game` `game1` join `game` `game2` on(((`game1`.`idCategory` = `game2`.`idCategory`) and (`game1`.`idGame` <> `game2`.`idGame`)))) join `category` on((`game1`.`idCategory` = `category`.`idCategory`))) order by `idGame`,`similarToIdGame`;

-- --------------------------------------------------------

--
-- Estructura para la vista `gameview`
--
DROP TABLE IF EXISTS `gameview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gameview` AS select `game`.`idGame` AS `idGame`,`game`.`name` AS `name`,`game`.`grantPublicAccess` AS `grantPublicAccess`,`game`.`secretGame` AS `secretGame`,`game`.`privateKey` AS `privateKey`,`game`.`idCategory` AS `idCategory`,`game`.`creationDate` AS `creationDate`,(select count(`comment`.`idComment`) from `comment` where (`comment`.`idGame` = `game`.`idGame`)) AS `timesCommented`,(select count(`gamelike`.`likeId`) from `gamelike` where (`gamelike`.`gameId` = `game`.`idGame`)) AS `popularity`,(select count(`gamescore`.`idScore`) from `gamescore` where (`gamescore`.`idGame` = `game`.`idGame`)) AS `timesPlayed`,(select count(`gameinstance`.`idGameInstance`) from `gameinstance` where ((`gameinstance`.`idGame` = `game`.`idGame`) and (`gameinstance`.`state` = 'INIT'))) AS `activity` from `game`;

-- --------------------------------------------------------

--
-- Estructura para la vista `totalgamesimilitudeview`
--
DROP TABLE IF EXISTS `totalgamesimilitudeview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `totalgamesimilitudeview` AS select `gamesimilitudeview`.`idGame` AS `idGame`,`gamesimilitudeview`.`similarToIdGame` AS `similarToIdGame`,count(0) AS `totalSimilitude` from `gamesimilitudeview` group by `gamesimilitudeview`.`idGame`,`gamesimilitudeview`.`similarToIdGame`;

-- --------------------------------------------------------

--
-- Estructura para la vista `userview`
--
DROP TABLE IF EXISTS `userview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `userview` AS select `game`.`idGame` AS `idGame`,`game`.`name` AS `name`,`game`.`grantPublicAccess` AS `grantPublicAccess`,(select `category`.`name` from `category` where (`category`.`idCategory` = `game`.`idCategory`)) AS `Category`,(select `state`.`state` from `state` where (`state`.`idState` = (select `developer`.`idstate` from `developer` where (`developer`.`idgame` = `game`.`idGame`)))) AS `State`,(select `platform`.`platform` from `platform` where (`platform`.`idPlatform` = (select `developer`.`idplatform` from `developer` where (`developer`.`idgame` = `game`.`idGame`)))) AS `Platform`,`game`.`creationDate` AS `creationDate`,(select `developer`.`idowner` from `developer` where (`developer`.`idgame` = `game`.`idGame`)) AS `idowner` from `game`;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
